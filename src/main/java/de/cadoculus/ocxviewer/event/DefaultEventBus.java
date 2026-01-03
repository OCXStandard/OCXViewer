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

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;

/**
 * Simple event bus implementation.
 *
 * <p>Subscribe and publish events. Events are published in channels distinguished by event type.
 * Channels can be grouped using an event type hierarchy.
 *
 * <p>You can use the default event bus instance {@link #getInstance}, which is a singleton,
 * or you can create one or multiple instances of {@link DefaultEventBus}.
 * @author Carsten Zerbst
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public final class DefaultEventBus implements EventBus {

    public DefaultEventBus() {
    }

    private final Map<Class<?>, Set<Consumer>> subscribers = new ConcurrentHashMap<>();

    @Override
    public <E extends Event> void subscribe(Class<? extends E> eventType, Consumer<E> subscriber) {
        Objects.requireNonNull(eventType);
        Objects.requireNonNull(subscriber);

        Set<Consumer> eventSubscribers = getOrCreateSubscribers(eventType);
        eventSubscribers.add(subscriber);
    }

    private <E> Set<Consumer> getOrCreateSubscribers(Class<E> eventType) {
        Set<Consumer> eventSubscribers = subscribers.get(eventType);
        if (eventSubscribers == null) {
            eventSubscribers = new CopyOnWriteArraySet<>();
            subscribers.put(eventType, eventSubscribers);
        }
        return eventSubscribers;
    }

    @Override
    public <E extends Event> void unsubscribe(Consumer<E> subscriber) {
        Objects.requireNonNull(subscriber);

        subscribers.values().forEach(eventSubscribers -> eventSubscribers.remove(subscriber));
    }

    @Override
    public <E extends Event> void unsubscribe(Class<? extends E> eventType, Consumer<E> subscriber) {
        Objects.requireNonNull(eventType);
        Objects.requireNonNull(subscriber);

        subscribers.keySet().stream()
            .filter(eventType::isAssignableFrom)
            .map(subscribers::get)
            .forEach(eventSubscribers -> eventSubscribers.remove(subscriber));
    }

    @Override
    public <E extends Event> void publish(E event) {
        Objects.requireNonNull(event);

        Class<?> eventType = event.getClass();
        subscribers.keySet().stream()
            .filter(type -> type.isAssignableFrom(eventType))
            .flatMap(type -> subscribers.get(type).stream())
            .forEach(subscriber -> publish(event, subscriber));
    }

    private <E extends Event> void publish(E event, Consumer<E> subscriber) {
        try {
            subscriber.accept(event);
        } catch (Exception e) {
            Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
        }
    }

    ///////////////////////////////////////////////////////////////////////////

    private static class InstanceHolder {

        private static final DefaultEventBus INSTANCE = new DefaultEventBus();
    }

    public static DefaultEventBus getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
