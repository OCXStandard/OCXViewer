/* SPDX-License-Identifier: MIT */
package de.cadoculus.ocxviewer.event;

import java.util.UUID;

/**
 * Base class for all events.
 *
 * <p>Each event has a unique identifier.
 *
 * This code is copied from atlantafx.sampler implemented by mkpaz. It is licensed under the MIT License.
 */
public abstract class Event {

    protected final UUID id = UUID.randomUUID();

    protected Event() {
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Event event)) {
            return false;
        }
        return id.equals(event.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Event{"
            + "id=" + id
            + '}';
    }

    public static <E extends Event> void publish(E event) {
        DefaultEventBus.getInstance().publish(event);
    }
}
