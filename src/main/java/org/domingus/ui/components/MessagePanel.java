package org.domingus.ui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MessagePanel extends JPanel {

	private static final long serialVersionUID = 1L;

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