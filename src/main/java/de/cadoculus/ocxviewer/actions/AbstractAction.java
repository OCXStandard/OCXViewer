package de.cadoculus.ocxviewer.actions;

/**
 * The abstract base class for actions.
 * All implementation must contain a static field for
 * the display name and keycode like
 * <pre>
 *     public final static KeyCodeCombination KEYS = new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN);
 *     public final static  String NAME = "About";
 * </pre>
 */
public abstract class AbstractAction {

    /**
     * The action code to runs
     */
    public abstract  void run();
}
