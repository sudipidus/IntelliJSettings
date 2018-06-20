import com.intellij.database.model.DasTable
import com.intellij.database.model.ObjectKind
import com.intellij.database.util.Case
import com.intellij.database.util.DasUtil

/*
 * Available context bindings:
 *   SELECTION   Iterable<DasObject>
 *   PROJECT     project
 *   FILES       files helper
 */

packageName = "set_package_name_here"
typeMapping = [
        (~/(?i)int/)                      : "long",
        (~/(?i)float|double|decimal|real/): "double",
        (~/(?i)datetime|timestamp/)       : "java.sql.Timestamp",
        (~/(?i)date/)                     : "java.sql.Date",
        (~/(?i)time/)                     : "java.sql.Time",
        (~/(?i)/)                         : "String"
]

FILES.chooseDirectoryAndSave("Choose directory", "Choose where to store generated files") { dir ->
    SELECTION.filter { it instanceof DasTable && it.getKind() == ObjectKind.TABLE }.each { generate(it, dir) }
}

def generate(table, dir) {
    def className = javaName(table.getName(), true)
    def fields = calcFields(table)
    new File(dir, className + ".java").withPrintWriter { out -> generate(out, className, fields, table.getName()) }
}

def generate(out, className, fields, tableName) {
    out.println "package $packageName"
    out.println ""
    out.println ""
    out.println "import javax.persistence.Entity;"
    out.println "import javax.persistence.Table;"
    out.println "import com.fasterxml.jackson.databind.PropertyNamingStrategy;"
    out.println "import com.fasterxml.jackson.databind.annotation.JsonNaming;"
    out.println "import lombok.Data;\n\n\n"
    out.println "@Entity"
    out.println "@Table(name = \"$tableName\")"
    out.println "@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)"
    out.println "@Data"
    out.println "public class $className {"
    out.println ""
    fields.each() {
        if (it.annos != "") out.println "  ${it.annos}"
        out.println "  private ${it.type} ${it.name};"
    }
    out.println ""
//not required since we are using lombok @Data annotation
//    fields.each() {
//        out.println ""
//        out.println "  public ${it.type} get${it.name.capitalize()}() {"
//        out.println "    return ${it.name};"
//        out.println "  }"
//        out.println ""
//        out.println "  public void set${it.name.capitalize()}(${it.type} ${it.name}) {"
//        out.println "    this.${it.name} = ${it.name};"
//        out.println "  }"
//        out.println ""
//    }
    out.println "}"
}

def calcFields(table) {
    DasUtil.getColumns(table).reduce([]) { fields, col ->
        def spec = Case.LOWER.apply(col.getDataType().getSpecification())
        def typeStr = typeMapping.find { p, t -> p.matcher(spec).find() }.value
        fields += [[
                           name : javaName(col.getName(), false),
                           type : typeStr,
                           annos: ""]]
    }
}

def javaName(str, capitalize) {
    def s = com.intellij.psi.codeStyle.NameUtil.splitNameIntoWords(str)
            .collect { Case.LOWER.apply(it).capitalize() }
            .join("")
            .replaceAll(/[^\p{javaJavaIdentifierPart}[_]]/, "_")
    capitalize || s.length() == 1 ? s : Case.LOWER.apply(s[0]) + s[1..-1]
}


