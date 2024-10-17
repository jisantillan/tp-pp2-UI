package org.domingus.test;

import java.util.HashSet;
import java.util.Set;

import org.domingus.app.AcademicOffer;
import org.domingus.interfaces.Observer;
import org.domingus.interfaces.Source;

public class SourceUI implements Source, Runnable {

    private Set<Observer> observers;
    private int version;

    public SourceUI(Integer timeInterval) {
        observers = new HashSet<>();
        TimerUI timer = new TimerUI(timeInterval, this);
        Thread thread = new Thread(timer);
        thread.start();
    }

    @Override
    public void suscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void send(AcademicOffer academicOffer) {
        observers.forEach((observer -> observer.update(academicOffer)));
    }

    @Override
    public void run() {
        send(new AcademicOffer(version++));
    }

}