package org.domingus.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.domingus.interfaces.Notificable;

public class View implements Notificable {
	
    private JPanel messagePanel;
    private JScrollPane scrollPane;

    public void init() {
        JFrame frame = new JFrame("Domingus Chat");
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Chat Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(new Color(50, 115, 220));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //Icon
        JLabel profileIcon = new JLabel() {
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(Color.WHITE);
                g2d.fillOval(0, 0, getWidth(), getHeight());
            }
        };
        profileIcon.setPreferredSize(new Dimension(40, 40));
        profileIcon.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1, true));


        JLabel chatTitle = new JLabel("Domingus");
        chatTitle.setForeground(Color.WHITE);
        chatTitle.setFont(new Font("Dialog", Font.BOLD, 18));

        headerPanel.add(profileIcon);
        headerPanel.add(Box.createRigidArea(new Dimension(10, 0)));  // Espaciado entre icono y título
        headerPanel.add(chatTitle);

        // Panel de mensajes (contenido)
        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        messagePanel.setBackground(Color.WHITE);

        // Scroll para los mensajes
        scrollPane = new JScrollPane(messagePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Panel de entrada de texto
        JPanel inputPanel = new JPanel(new BorderLayout());
        JTextField textField = new JTextField();
        textField.setEnabled(false);  // Inhabilitado para solo recibir notificaciones
        inputPanel.add(textField, BorderLayout.CENTER);

        // Botón enviar (inhabilitado)
        JButton sendButton = new JButton(">>");
        sendButton.setEnabled(false);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // Añadir componentes al frame
        frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    // Método para mostrar notificaciones como burbujas de mensajes
    private void showNotification(String message, boolean isUser) {
        JPanel messageBubble = new JPanel();
        messageBubble.setLayout(new BoxLayout(messageBubble, BoxLayout.Y_AXIS));
        messageBubble.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Padding para el mensaje

        JLabel notificationLabel = new JLabel("<html>" + message + "</html>");
        notificationLabel.setOpaque(false);
        notificationLabel.setForeground(Color.BLACK);
        notificationLabel.setAlignmentX(isUser ? Component.RIGHT_ALIGNMENT : Component.LEFT_ALIGNMENT);
        notificationLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Padding interno del texto

        notificationLabel.setAlignmentX(isUser ? Component.RIGHT_ALIGNMENT : Component.LEFT_ALIGNMENT);
        notificationLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Padding interno del texto

        // Redondear los bordes de la burbuja de mensaje
        messageBubble.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1, true));

        messageBubble.add(notificationLabel);
        messageBubble.setAlignmentX(isUser ? Component.RIGHT_ALIGNMENT : Component.LEFT_ALIGNMENT);

        messagePanel.add(messageBubble);
        messagePanel.revalidate();  // Actualiza el panel para que se muestre el nuevo mensaje
        messagePanel.repaint();  // Redibuja el panel para que se muestre el nuevo mensaje

        // Hacer que el scroll baje automáticamente hasta el último mensaje
        SwingUtilities.invokeLater(() -> scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()));
    }


    @Override
	public void sendMessage(String message) {
        //showNotification("Nueva notificación: " + message, false);
        showNotification(message, false);
	}

}