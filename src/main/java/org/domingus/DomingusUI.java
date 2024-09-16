package org.domingus;


import org.domingus.ui.View;

import java.beans.PropertyChangeEvent;

public class DomingusUI {
    public static void main(String[] args) {
        //Aca se deberia inicializar usando el json

        //Domingus domingus = new DomingusFactory(archivo json).create();
        View view = new View();
        view.init();

        for (int i = 1; i <= 20; i++) {
            PropertyChangeEvent event = new PropertyChangeEvent(view, "notificacion", null, "Mensaje " + i);
            view.propertyChange(event);

            // Para simular
            try {
                Thread.sleep(1000);  // 1 segundo entre notificaciones
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}