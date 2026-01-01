/*
 * Copyright 2025 Carsten Zerbst
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.cadoculus.ocxviewer.event;


import javafx.scene.Scene;

public final class ThemeEvent extends Event {

    public enum EventType {
        // theme can change both, base font size and colors
        THEME_CHANGE,
        // font size or family only change
        FONT_CHANGE,
        // colors only change
        COLOR_CHANGE,
        // new theme added or removed
        THEME_ADD,
        THEME_REMOVE
    }

    private final EventType eventType;

    public ThemeEvent(EventType eventType) {
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        return "ThemeEvent{"
                + "eventType=" + eventType
                + "} " + super.toString();
    }
}
