package org.domingus.ui;

import org.domingus.app.Domingus;
import org.domingus.interfaces.Observer;
import org.domingus.ui.components.NotifierFilter;

import java.util.Set;
import java.util.stream.Collectors;


public class DomingusController {
	
	private Domingus domingus;
	private DomingusView domingusView;


	public DomingusController(Domingus domingus, DomingusView domingusView) {
		this.domingus = domingus;
		this.domingusView = domingusView;
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
		NotifierFilter notifierFilter = new NotifierFilter();
		Set<Observer> allNotifiers = notifierFilter.getNotifiers(domingus.getObservers());
		Set<Observer> currentNotifiers = notifierFilter.getNotifiers(domingus.getCurrentObservers());

		domingusView.updateMenuBarWithExtensions(notifierFilter.getNames(allNotifiers), notifierFilter.getNames(currentNotifiers));
	}

	public Observer getObserver(String name){
		Observer observer = null;
		Set<Observer> notifiers = new NotifierFilter().getNotifiers(domingus.getObservers());
		for (Observer notifier : notifiers) {
			if (notifier.getClass().getSimpleName().equals(name)){
				observer=notifier;
				break;
			}
		}
		return observer;
	}
}