package org.domingus.ui;

import org.domingus.app.Domingus;
import org.domingus.interfaces.Observer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Controller {
	
	private Domingus domingus;
	private View view;


	public Controller(Domingus domingus, View view) {
		this.domingus = domingus;
		this.view = view;
	}
	
	public void useExtension(String name) {
		domingus.addCurrentObserver(getObserver(name));
		updateExtensionsBar();
	}
	
	public void dropExtension(String name) {
		domingus.removeCurrentObserver(getObserver(name));
		System.out.println("Se ha retirado el medio de notificacion: " + name);
		updateExtensionsBar();
	}

	private void updateExtensionsBar() {
		view.updateMenuBarWithExtensions(getNames(domingus.getNotifiers()), getNames(domingus.getCurrentNotifiers()));
	}

	public Set<String> getNames(Set<Observer> observers){
		return observers.stream().map(notifier -> notifier.getClass().getSimpleName()).collect(Collectors.toSet());
	}

	public Observer getObserver(String name){
		Observer observer = null;
		for (Observer notifier : domingus.getNotifiers()) {
			if (notifier.getClass().getSimpleName().equals(name)){
				observer=notifier;
				break;
			}
		}
		return observer;
	}
}