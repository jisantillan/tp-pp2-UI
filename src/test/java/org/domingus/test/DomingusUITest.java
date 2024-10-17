package org.domingus.test;

import java.io.FileNotFoundException;

import org.domingus.app.Domingus;
import org.domingus.init.DomingusFactory;
import org.domingus.interfaces.Source;
import org.domingus.ui.Controller;
import org.domingus.ui.View;

public class DomingusUITest {
	
	private static String EXTENSIONS_PATH = "src\\test\\resources\\extensions\\";
	private static Integer TIME_INTERVAL = 1000;
	
    public static void main(String[] args) throws FileNotFoundException {
    	
    	View view = new View();
    	view.init();
    	
    	Source source = new SourceUIMock(TIME_INTERVAL);
		DomingusFactory factory = new DomingusFactory();
		Domingus domingus = factory.create(source, EXTENSIONS_PATH);
		
		Controller controller = new Controller(domingus, view);

    	domingus.addNotifier(view);
    	domingus.addCurrentNotifier(view.getName());
    	
    	view.setMenuBarWithExtensions(domingus.getAllNotifiersNames(), domingus.getCurrentNotifiersNames(), controller);
        
    }

}