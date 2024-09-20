package org.domingus.ui.components;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {


    private final String chatName;
    private static final String ICON_PATH = "images/Domingus.jpeg";

    public HeaderPanel(String chatName) {
        this.chatName=chatName;
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(new Color(50, 115, 220));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel profileIcon = createProfileIcon();
        JLabel chatTitle = createChatTitle();

        add(profileIcon);
        add(Box.createRigidArea(new Dimension(10, 0)));  // Espaciado entre icono y título
        add(chatTitle);
    }

    private JLabel createProfileIcon() {
        JLabel profileIcon;

        try {
            // Intenta cargar la imagen desde la carpeta del proyecto
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(ICON_PATH));

            // Verifica si la imagen realmente se pudo cargar
            if (icon.getImageLoadStatus() == MediaTracker.ERRORED) {
                throw new Exception("Imagen no encontrada");
            }

            // Escala la imagen al tamaño deseado
            Image scaledImage = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

            // Crea el JLabel con la imagen escalada
            profileIcon = new JLabel(new ImageIcon(scaledImage));
        } catch (Exception e) {
            // Si ocurre una excepción (por ejemplo, la imagen no se encuentra), dibuja un círculo
            profileIcon = new JLabel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.setColor(Color.WHITE);
                    g2d.fillOval(0, 0, getWidth(), getHeight());
                }
            };
        }

        profileIcon.setPreferredSize(new Dimension(40, 40));
        profileIcon.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1, true));

        return profileIcon;
    }


    private JLabel createChatTitle() {
        JLabel chatTitle = new JLabel(chatName);
        chatTitle.setForeground(Color.WHITE);
        chatTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        return chatTitle;
    }
}

