package org.domingus.test;

import java.io.FileNotFoundException;

import org.domingus.app.Domingus;
import org.domingus.init.DomingusFactory;
import org.domingus.interfaces.Source;
import org.domingus.ui.View;

public class DomingusUITest {
	
	private static String EXTENSIONS_PATH = "src\\test\\resources\\extensions\\";
	
    public static void main(String[] args) throws FileNotFoundException {
    	
    	View view = new View();
    	view.init();
    	
    	Source source = new SourceUIMock(1000);
		DomingusFactory factory = new DomingusFactory();
		Domingus domingus = factory.create(source, EXTENSIONS_PATH);

    	domingus.addNotifier(view);
    	domingus.addCurrentNotifier(view.getName());

    }

}