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
	
}