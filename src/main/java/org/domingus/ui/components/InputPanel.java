package org.domingus.ui.components;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    public InputPanel() {
        setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        textField.setEnabled(false);  // Inhabilitado para solo recibir notificaciones

        JButton sendButton = new JButton(">>");
        sendButton.setEnabled(false);

        add(textField, BorderLayout.CENTER);
        add(sendButton, BorderLayout.EAST);
    }
}

