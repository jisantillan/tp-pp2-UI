package org.domingus.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.domingus.app.Domingus;
import org.domingus.interfaces.Source;
import org.domingus.ui.View;

public class DomingusUITest {
	
    public static void main(String[] args) throws InterruptedException {
    	
    	View view = new View();
    	view.init();
    	
    	Source source = new SourceUIMock(1000);
    	Domingus domingus = new Domingus(source);
    	domingus.addObserver(view);
    	
    	try {
    		domingus.init("src\\main\\resources\\extensions\\");
		} catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException
				| IllegalAccessException | InterruptedException | IOException e) {
			e.printStackTrace();
		}

    }

}