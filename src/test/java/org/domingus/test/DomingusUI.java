package org.domingus.test;

import java.io.FileNotFoundException;

import org.domingus.app.Domingus;
import org.domingus.init.DomingusFactory;
import org.domingus.interfaces.Source;
import org.domingus.ui.View;

public class DomingusUI {
	
	private static String EXTENSIONS_PATH = "src\\test\\resources\\extensions\\";
	private static Integer TIME_INTERVAL = 1000;
	
    public static void main(String[] args) throws FileNotFoundException {
		Source source = new SourceUI(TIME_INTERVAL);
		DomingusFactory factory = new DomingusFactory();
		Domingus domingus = factory.create(source, EXTENSIONS_PATH);

		View view = new View(domingus);
		view.init();
    }

}