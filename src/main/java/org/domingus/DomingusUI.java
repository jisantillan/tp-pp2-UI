package org.domingus;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.domingus.app.Domingus;
import org.domingus.ui.View;

public class DomingusUI {
	
    public static void main(String[] args) {
    	
    	View view = new View();
    	view.init();
    	
    	Domingus domingus = new Domingus();
    	domingus.addObserver(view);
    	try {
			domingus.init(args);
		} catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException
				| IllegalAccessException | InterruptedException | IOException e) {
			e.printStackTrace();
		}

    }

}