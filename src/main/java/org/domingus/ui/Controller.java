package org.domingus.ui;

import org.domingus.app.Domingus;

public class Controller {
	
	private Domingus domingus;
	private View view;

	public Controller(Domingus domingus, View view) {
		this.domingus = domingus;
		this.view = view;
	}
	
	public void useExtension(String name) {
		domingus.addCurrentNotifier(name);
		updateExtensionsBar();
	}
	
	public void dropExtension(String name) {
		domingus.removeCurrentNotifier(name);
		System.out.println("Se ha retirado el medio de notificacion: " + name);
		updateExtensionsBar();
	}

	private void updateExtensionsBar() {
		view.setMenuBarWithExtensions(
    			domingus.getAllNotifiersNames(),
    			domingus.getCurrentNotifiersNames(),
    			this
    	);
	}

}