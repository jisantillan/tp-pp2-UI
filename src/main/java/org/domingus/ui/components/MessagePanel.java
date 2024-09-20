package org.domingus.ui.components;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import static javax.swing.text.StyleConstants.setBackground;

public class MessagePanel extends JPanel {
    public MessagePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
    }

    public void addMessage(String message, boolean isUser) {
        JPanel messageBubble = new JPanel();
        messageBubble.setLayout(new BoxLayout(messageBubble, BoxLayout.Y_AXIS));
        messageBubble.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel notificationLabel = new JLabel("<html><div style='width: 250px;'>" + message + "</div></html>");
        notificationLabel.setForeground(Color.BLACK);
        notificationLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        messageBubble.add(notificationLabel);
        messageBubble.setAlignmentX(isUser ? Component.RIGHT_ALIGNMENT : Component.LEFT_ALIGNMENT);

        add(messageBubble);
        add(Box.createRigidArea(new Dimension(0,5)));
        revalidate();
        repaint();
    }
}
