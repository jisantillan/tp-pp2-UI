package org.domingus.ui.components;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {


    private final String chatName;

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
        JLabel profileIcon = new JLabel() {
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
        return profileIcon;
    }

    private JLabel createChatTitle() {
        JLabel chatTitle = new JLabel(chatName);
        chatTitle.setForeground(Color.WHITE);
        chatTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        return chatTitle;
    }
}

