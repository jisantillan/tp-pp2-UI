package org.domingus.test;

import java.io.FileNotFoundException;

import org.domingus.app.Domingus;
import org.domingus.init.DomingusFactory;
import org.domingus.interfaces.Source;
import org.domingus.ui.View;

public class DomingusUITest {
	
    public static void main(String[] args) throws FileNotFoundException {
    	
    	View view = new View();
    	view.init();
    	
    	Source source = new SourceUIMock(1000);
		DomingusFactory factory = new DomingusFactory();
		Domingus domingus = factory.create(source, "src\\test\\resources\\extensions\\");

    	domingus.addObserver(view);


    }

}