package org.domingus.ui.components;

import org.domingus.interfaces.Notifier;
import org.domingus.interfaces.Observer;

import java.util.Set;
import java.util.stream.Collectors;

public class NotifierFilter {

    public NotifierFilter(){
    }

    public Set<Observer> getNotifiers(Set<Observer> observers) {
        return observers.stream()
                .filter(observer -> observer.getClass().isAnnotationPresent(Notifier.class))
                .collect(Collectors.toSet());
    }

    public Set<String> getNames(Set<Observer> observers) {
        return observers.stream().map(notifier -> notifier.getClass().getSimpleName()).collect(Collectors.toSet());
    }
}
