package org.domingus.test;

import java.io.IOException;

import org.domingus.app.Domingus;
import org.domingus.init.DomingusFactory;
import org.domingus.init.LoggerFactory;
import org.domingus.interfaces.Source;
import org.domingus.logger.Logger;
import org.domingus.ui.DomingusView;

public class DomingusUI {

	private static String EXTENSIONS_PATH = "src\\test\\resources\\extensions\\";
	private static String MEMORY_PATH = "src\\test\\resources\\memory.txt";
	private static Integer TIME_INTERVAL = 2000;
	
    public static void main(String[] args) throws IOException {
    	
		Source source = new SourceUI();
		TimerUI timer = new TimerUI(TIME_INTERVAL, (Runnable) source);
		
		DomingusFactory factory = new DomingusFactory();
		Domingus domingus = factory.create(source, EXTENSIONS_PATH);
		
		LoggerFactory loggerFactory = new LoggerFactory();
		Logger logger = loggerFactory.create(MEMORY_PATH);

		domingus.addObserver(logger);
		domingus.addCurrentObserver(logger.getClass().getSimpleName());
		
		DomingusView domingusView = new DomingusView(domingus);
		domingusView.init();

		timer.run();
    }

}