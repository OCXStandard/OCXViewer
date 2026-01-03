/* SPDX-License-Identifier: MIT */
package de.cadoculus.ocxviewer.event;

import javafx.scene.input.KeyCodeCombination;

/**
 * Event representing a hotkey press.
 *
 * This code is copied from atlantafx.sampler implemented by mkpaz. It is licensed under the MIT License.
 */
public final class HotkeyEvent extends Event {

    private final KeyCodeCombination keys;

    public HotkeyEvent(KeyCodeCombination keys) {
        this.keys = keys;
    }

    public KeyCodeCombination getKeys() {
        return keys;
    }

    @Override
    public String toString() {
        return "HotkeyEvent{"
            + "keys=" + keys
            + "} " + super.toString();
    }
}
