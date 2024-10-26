package org.domingus.ui;

import java.util.Set;

import org.domingus.app.Domingus;


public class DomingusController {
	
	private Domingus domingus;
	private DomingusView domingusView;


	public DomingusController(Domingus domingus, DomingusView domingusView) {
		this.domingus = domingus;
		this.domingusView = domingusView;
	}
	
	public void useExtension(String name) {
		domingus.addCurrentObserver(name);
		System.out.println("Se ha agregado el medio de notificacion: " + name);
		updateExtensionsBar();
	}
	
	public void dropExtension(String name) {
		domingus.removeCurrentObserver(name);
		System.out.println("Se ha retirado el medio de notificacion: " + name);
		updateExtensionsBar();
	}

	private void updateExtensionsBar() {
		Set<String> allNames = domingus.getAllObserversNames();
		Set<String> currentNames = domingus.getCurrentObserversNames();
		domingusView.updateMenuBarWithExtensions(allNames, currentNames);
	}

}