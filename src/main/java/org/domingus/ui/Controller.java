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
    	view.setMenuBarWithExtensions(
    			domingus.getAllNotifiersNames(),
    			domingus.getCurrentNotifiersNames(),
    			this
    	);
	}
	
	public void dropExtension(String name) {
		// TODO Use the true method from Core when exist
		//domingus.addCurrentNotifier(name);
		System.out.println("Se ha retirado el medio de notificacion: " + name);
    	
		view.setMenuBarWithExtensions(
    			domingus.getAllNotifiersNames(),
    			domingus.getCurrentNotifiersNames(),
    			this
    	);
	}
	
}