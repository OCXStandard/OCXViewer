/*
Copyright 2025 Carsten Zerbst

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package de.cadoculus.ocxviewer.event;

import java.util.function.Consumer;

public interface EventBus {

    /**
     * Subscribe to an event type.
     *
     * @param eventType  the event type, can be a super class of all events to subscribe.
     * @param subscriber the subscriber which will consume the events.
     * @param <T>        the event type class.
     */
    <T extends Event> void subscribe(Class<? extends T> eventType, Consumer<T> subscriber);

    /**
     * Unsubscribe from all event types.
     *
     * @param subscriber the subscriber to unsubscribe.
     */
    <T extends Event> void unsubscribe(Consumer<T> subscriber);

    /**
     * Unsubscribe from an event type.
     *
     * @param eventType  the event type, can be a super class of all events to unsubscribe.
     * @param subscriber the subscriber to unsubscribe.
     * @param <T>        the event type class.
     */
    <T extends Event> void unsubscribe(Class<? extends T> eventType, Consumer<T> subscriber);

    /**
     * Publish an event to all subscribers.
     *
     * <p>The event type is the class of <code>event</code>. The event is published to all consumers which subscribed to
     * this event type or any super class.
     *
     * @param event the event.
     */
    <T extends Event> void publish(T event);

}