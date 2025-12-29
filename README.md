# OCX Viewer

An application to view the contents of OCX files.

# Architecture

# UI
The UI is implemented JavaFX.  

## Event Handling
Event handling is based on a simple event bus found in the ``de.cadoculus.ocxviewer.event`` package.
The following event types are found on the bus
* HotkeyEvent: contains any kind of key events
* OpenEvent: an event fired when a new OCX file is opened
* NavigationEvent: an event fired from the navigation tree

## Actions
The operations are started by actions. All actions must derive from the ``AbstractAction`` class.
The ``de.cadoculus.ocxviewer.actions.ActionDispatcher`` dispatches key events to actions.
This requires the action to contain a static field with the desired key code like 
```
public static final KeyCodeCombination KEYS = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);
```
## UI Ressources

The AtlantaFX theme collection (https://mkpaz.github.io/atlantafx/) is used for styling the user interface. 
The ikonli icon collection (https://github.com/kordamp/ikonli) with the material design is used for icons.
The flags displayed with the I18N portion of UnitsML are 
taken from
https://github.com/yammadev/flag-icons?tab=readme-ov-file

The title images are taken from 
> Vérany, Jean Baptiste. (1851). Mollusques méditeranéens [!]; observés, décrits, figurés, et chromolithographiés d’après le vivant ... Impr, des sourds-muets. https://www.biodiversitylibrary.org/item/104831

# XML Reading
The data model used by the UI is automatically generated from the OCX XSD Schema
using the hisrc-basicjaxb-tools MVN plugin.

In the future, a concept to read multiple OCX version must be added.

# XML Schema Check

To be implemented.

# Schematron

To be implemented.

# License

This project is licensed under the Apache License - see the [LICENSE](LICENSE) file for details.

