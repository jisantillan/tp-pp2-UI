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
		// TODO: Usar nuevo metodo de domingus
		// domingus.addCurrentObserver(name);
		System.out.println("Se ha agregado el medio de notificacion: " + name);
		updateExtensionsBar();
	}
	
	public void dropExtension(String name) {
		// TODO: Usar nuevo metodo de domingus
		// domingus.removeCurrentObserver(name);
		System.out.println("Se ha retirado el medio de notificacion: " + name);
		updateExtensionsBar();
	}

	private void updateExtensionsBar() {
		// TODO: Usar nuevo metodo de domingus
		Set<String> allNames = null; 
		Set<String> currentNames = null; 
		domingusView.updateMenuBarWithExtensions(allNames, currentNames);
	}

}