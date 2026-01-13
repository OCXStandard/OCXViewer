# OCX Viewer

This application is developed to help find issues in OCX files and to get a better understanding of the OCX format.
It is intended to be used by OCX file authors and consumers to validate and inspect OCX files, not as a generic 3D viewer or editor.

# Architecture

The OCXViewer is implemented as a JAVA rich-client application.

# Build System
The build system is based on Maven. The ``pom.xml`` file contains all dependencies and plugins required to build the application.
Before building the application a first time
* make sure to have a JDK 21 or higher installed 
* when compiling from the command line, ensure maven uses this as the default JAVA version
* download the JavaFX SDK from https://openjfx.io/ and extract it to a local folder
    * ${project.basedir}/binaries/linux/javafx-sdk-21.0.7/lib on Linux
    * ${project.basedir}/binaries/windows/javafx-sdk-21.0.7/lib on Windows
* run ``mvn clean install`` to build the application

Start the application, using the following command line arguments on Linux:

```
java --enable-native-access=javafx.graphics 
  --module-path binaries/linux/javafx-sdk-21.0.9/lib:target:target/lib 
  --add-modules javafx.controls,javafx.graphics,javafx.fxml,ocxviewer
  de.cadoculus.ocxviewer.Main --log data/log4j2.xml
```

and on Windows:

```
java --enable-native-access=javafx.graphics 
  --module-path binaries\windows\javafx-sdk-21.0.9\lib;target;target\lib 
  --add-modules javafx.controls,javafx.graphics,javafx.fxml,ocxviewer
  de.cadoculus.ocxviewer.Main --log data\log4j2.xml
```

The difference are only the module-path separator (``:`` on Linux, ``;`` on Windows) and the path separators (``/`` on Linux, ``\`` on Windows).

# UI
The UI is implemented JavaFX. The main components are:
* A menu bar on the top of the window
* A navigation tree on the left side of the window
* A detail view on the right side of the window showing details of the selected element in the navigation tree. In some cases, this detail view allow a drill down to children elements, e.g. follow the panels->panel->stiffener hierachy. 

## Event Handling
Event handling is based on a simple event bus found in the ``de.cadoculus.ocxviewer.event`` package.
This is a copy from the AtlantaFX sample application (https://mkpaz.github.io/atlantafx/).
The following event types are found on the bus
* HotkeyEvent: contains any kind of key events
* OpenEvent: an event fired when a new OCX file is opened
* NavigationEvent: an event fired from the navigation tree
* SelectionEvent: an event fired when an element is selected in the detail view. TODO: merge with NavigationEvent?
* WindowEvent: an event fired when the main window is shown or closed
* ThemeEvent: an event fired when the theme is changed


## Actions
All actions must derive from the ``AbstractAction`` class. The ``de.cadoculus.ocxviewer.actions.ActionDispatcher`` dispatches key events to actions.
This requires the action to contain a static field with the desired key code like 
```
public static final KeyCodeCombination KEYS = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);
```
The code to dispatch the action is found in the ``handleHotkeyEvent(HotkeyEvent event)`` method of the ActionDispatcher class.

### About Action
Shows the about dialog containing the building information like version, git commit id and build date.

### Exit Action
Exits the application.
### Help Action
Shows the help dialog.
### Open Action
Opens a file chooser dialog to select an OCX file to open.
### XML Schema Check
To be implemented.
### Schematron
To be implemented.

## UI Ressources

The AtlantaFX theme collection (https://mkpaz.github.io/atlantafx/) is used for styling the user interface. 
The ikonli icon collection (https://github.com/kordamp/ikonli) with the material design is used for icons.
The flags displayed with the I18N portion of UnitsML are 
taken from
https://github.com/yammadev/flag-icons?tab=readme-ov-file

The title images are taken from 
> Vérany, Jean Baptiste. (1851). Mollusques méditeranéens [!]; observés, décrits, figurés, et chromolithographiés d’après le vivant ... Impr, des sourds-muets. https://www.biodiversitylibrary.org/item/104831

# XML Reading
The data model is automatically generated from the OCX XSD Schema using the hisrc-basicjaxb-tools MVN plugin.
The OCXIO class is the main entry point to read and write OCX files. It enforces all files are read and written using the OCX version 3.1.0 binding.


# License

This project is licensed under the Apache License - see the [LICENSE](LICENSE) file for details.

