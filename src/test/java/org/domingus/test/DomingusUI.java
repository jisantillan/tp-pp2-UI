package org.domingus.test;

import java.io.IOException;

import org.domingus.app.Domingus;
import org.domingus.init.DomingusFactory;
import org.domingus.init.LoggerFactory;
import org.domingus.interfaces.Source;
import org.domingus.logger.Logger;
import org.domingus.ui.DomingusView;

import static java.util.Objects.nonNull;

public class DomingusUI {

	private static String EXTENSIONS_PATH = "src\\test\\resources\\extensions\\";
	private static String MEMORY_PATH = "src\\test\\resources\\memory.txt";

    public static void main(String[] args) throws IOException {
    	
		Source source = new SourceUI();

		Integer timeInterval = null;
		try	{
			timeInterval = Integer.valueOf(args[0]);
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("Error obteniendo los segundos por parámetro");
		}

		if(nonNull(timeInterval)) {
			TimerUI timer = new TimerUI(timeInterval, (Runnable) source);

			DomingusFactory factory = new DomingusFactory();
			Domingus domingus = factory.create(source, EXTENSIONS_PATH);

			LoggerFactory loggerFactory = new LoggerFactory();
			Logger logger = loggerFactory.create(MEMORY_PATH);

			domingus.addObserver(logger);

			DomingusView domingusView = new DomingusView(domingus);
			domingusView.init();

			timer.run();
		}
    }

}