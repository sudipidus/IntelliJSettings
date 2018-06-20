# IntelliJ Settings And Productivity
This repo contains Exported Jar of my Intellij  IDEA settings. (Editor preferences, Keymaps and so on) In addition there are the descriptions of my key map which I have set to enhance productivity. This is meant to be a reference for me. Collaboration and suggestions are welcome

>**Usage:**
**Download settings.jar file and follow:**
[Imorting Settings](https://www.jetbrains.com/help/idea/exporting-and-importing-settings.html#import_settings_from_jar_archive)
[Exporting Settings](https://www.jetbrains.com/help/idea/exporting-and-importing-settings.html#export_settings_to_jar_archive)



**Some Useful Resources:**

[Java and Android IntelliJ Wizardry Lite with Heinz Kabutz (Free at Udemy)](https://www.udemy.com/jetbrains-intellij-wizardry-lite-with-heinz-kabutz)
 
[IntellijIDEA SubReddit](https://www.reddit.com/r/IntelliJIDEA/) 

[IntellijIDEA StackOverflow](https://stackoverflow.com/search?q=intellijIDEA) 

[IntelliJ Official Blog](https://blog.jetbrains.com/idea/) 

[Vojtech Ruzicka's Programming Blog (on Intellij Productivity)](http://vojtechruzicka.com/?s=intellij) 

[Intellij (Medium)](https://medium.com/search?q=intellijIDEA) 

[Intellij (Quora)](https://www.quora.com/topic/IntelliJ-IDEA) 

[JetBrainsTV (Youtube)](https://www.youtube.com/channel/UCGp4UBwpTNegd_4nCpuBcow) 

[Intellij Feature Trainer plugin](https://plugins.jetbrains.com/plugin/8554-ide-features-trainer)

**Scripted Extensions**

We can use scripted extension for achieving various mundane repeatitive tasks. Lets take example of creating pojo from each db table. Included in this repo is a file `generate_pojos.groovy`. Place it inside `Scratches and Consoles->Extensions->Database Tools and SQL->Schema`. Right click on table name in DB view, choose script, choose directory location and save. Modify the groovy script to change package name.

We can have as many groovy scripts as we would like to have. Personally I have found this approach easier to do scripting tasks like file creation (mostly model pojo, repository, etc)

# # Quick Tips (Lookup)

| Key ShortCut  | Action |
| ------------- | ------------- |
| Windows+D  | Toggle distraction free mode (hides all the toolbars, just code window is displayed)  |
| Windows+F  | Toggle Full screen mode  |
|Alt+Left Arrow| Navigate back (useful while debugging (stepping in deeper into methods/classes)|
|Alt+Right Arrow|Navigate forward|
|F2|Jump to (next) Error|
|Alt-Enter| '\r' carriage return (when cursor is not necessarily at the line-end)|


#Commonly Used Operations

	1.  Regex Search for  multiple words: (word1).*(word2)|\2.*\1


**Ctrl-Shift A (Master Key):**
![Material Theme](https://github.com/sudipbhandari126/IntelliJSettings/blob/master/resources/master_action.gif  "Jaxb Demo")


**Material Theme:**
![Material Theme](https://github.com/sudipbhandari126/IntelliJSettings/blob/master/resources/material_%20theme.gif  "Jaxb Demo")


**Debugging/Changing Values Dynamically:**
![Debuggin/Chaning Values](https://github.com/sudipbhandari126/IntelliJSettings/blob/master/resources/debugging_changing_values_dynamically.gif  "Debuggin/Chaning Values")


**Toggling distraction-free/full-screen mode:**
![Toggling distraction-free/full-screen mode](https://github.com/sudipbhandari126/IntelliJSettings/blob/master/resources/toggle_distraction_full_screen.gif  "Toggling distraction-free/full-screen mode")

**Git Blame**
`git blame` is a command which shows the contributor to a particular file line by line. Using it in terminal is fairly easy: `git blame $filename`. In Intellij we can set root for the VCS (Version control system). Now `git blame` translates to  `Annotations` under VCS->Git and it displays line by line contributor in a nice formatted way. This can be very useful when working in a large project or dealing with merge conflicts.
![VCS Annotation](https://github.com/sudipbhandari126/IntelliJSettings/blob/master/resources/git_blame_VCS_annotations.gif  "Git Blame Annotation Intellij")

**Share Run/Debug Configurations**
When working on large projects with a lot of dependencies and configuration details it can be PITA just to set up and configure your project. You can share the run/debug configuration to solve this.
![Share Configurations](https://github.com/sudipbhandari126/IntelliJSettings/blob/master/resources/share_configurations.gif  "Share run/debug configurations")
