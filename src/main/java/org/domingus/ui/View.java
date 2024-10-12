package org.domingus.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;


import org.domingus.interfaces.Notifier;
import org.domingus.ui.components.HeaderPanel;
import org.domingus.ui.components.InputPanel;
import org.domingus.ui.components.MessagePanel;

public class View implements Notifier {
	
	private static String NAME = "DomngusUI";
    private MessagePanel messagePanel;
    private JScrollPane scrollPane;

    public void init() {
        JFrame frame = new JFrame("Domingus Chat");
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Chat Header
        HeaderPanel headerPanel = new HeaderPanel("Domingus Chat");

        //Message Panel
        messagePanel = new MessagePanel();
        scrollPane = new JScrollPane(messagePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Panel de entrada de texto
        InputPanel inputPanel = new InputPanel();

        // Añadir componentes al frame
        frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void showNotification(String message, boolean isUser) {
        messagePanel.addMessage(message, isUser);
        // Hacer que el scroll baje automáticamente hasta el último mensaje
        SwingUtilities.invokeLater(() -> scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()));
    }

    @Override
	public void notify(String message) {
        showNotification(message, false);
	}

	@Override
	public String getName() {
		return NAME;
	}

}