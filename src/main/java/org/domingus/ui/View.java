package org.domingus.ui;

import java.awt.BorderLayout;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;


import org.domingus.app.Domingus;
import org.domingus.interfaces.Notifier;
import org.domingus.interfaces.Observer;
import org.domingus.ui.components.HeaderPanel;
import org.domingus.ui.components.InputPanel;
import org.domingus.ui.components.MessagePanel;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class View implements Observer {

    private static final String DOMINGUS_CHAT_HEADER = "Domingus Chat";
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;
    private static final String CONFIG_LBL = "Configuración";
    private static final String USE_NOTIFIER_LBL = "Usar notificador";
    private static final String REMOVE_NOTIFIER_LBL = "Retirar notificador";
    private static String NAME = "DomingusUI";
    private MessagePanel messagePanel;
    private JScrollPane scrollPane;
    private JFrame frame;

    private Controller controller;
    private Domingus domingus;

    public View(Domingus domingus) {
        this.domingus = domingus;
        this.controller = new Controller(domingus, this);
        this.frame = new JFrame(DOMINGUS_CHAT_HEADER);
        this.messagePanel = new MessagePanel();
        this.scrollPane = new JScrollPane(messagePanel);
    }

    public void init() {
        //El nombre del método es para hacerlo explicito nomás
        this.suscribeToDomingus();

        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(FALSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Chat Header
        HeaderPanel headerPanel = new HeaderPanel(DOMINGUS_CHAT_HEADER);

        //Message Panel
        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Panel de entrada de texto
        InputPanel inputPanel = new InputPanel();

        // Añadir componentes al frame
        frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);
        frame.setVisible(TRUE);

        this.updateMenuBarWithExtensions(controller.getNames(domingus.getNotifiers()), controller.getNames(domingus.getCurrentNotifiers()));
    }

    private void suscribeToDomingus() {
        this.domingus.addObserver(this);
        this.domingus.addCurrentObserver(this);
    }

    private void showNotification(String message, Boolean isUser) {
        messagePanel.addMessage(message, isUser);
        // Hacer que el scroll baje automáticamente hasta el último mensaje
        SwingUtilities.invokeLater(() -> scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()));
    }

    //Para recibir los observers del controlador
    public void updateMenuBarWithExtensions(Set<String> allNotifiers, Set<String> currentNotifiers) {
        JMenuBar menuBar = new JMenuBar();
        JMenu configMenu = new JMenu(CONFIG_LBL);

        JMenu useExtensionMenu = getAddNotifierMenu(allNotifiers, currentNotifiers);
        JMenu dropExtensionMenu = getRemoveNotifierMenu(allNotifiers, currentNotifiers);

        configMenu.add(useExtensionMenu);
        configMenu.add(dropExtensionMenu);
        menuBar.add(configMenu);
        this.frame.setJMenuBar(menuBar);
        this.frame.revalidate();
        this.frame.repaint();
    }

    private JMenu getRemoveNotifierMenu(Set<String> allNotifiers, Set<String> currentNotifiers) {
        JMenu dropExtensionMenu = new JMenu(REMOVE_NOTIFIER_LBL);

        for (String notifier : allNotifiers) {
            JMenuItem extensionItem = new JMenuItem(notifier);
            if (!currentNotifiers.contains(notifier)) {
                extensionItem.setEnabled(FALSE);
            } else {
            	extensionItem.addActionListener(e -> controller.dropExtension(notifier));
            }
            dropExtensionMenu.add(extensionItem);
        }
        return dropExtensionMenu;
    }

    private JMenu getAddNotifierMenu(Set<String> allNotifiers, Set<String> currentNotifiers) {
        JMenu useExtensionMenu = new JMenu(USE_NOTIFIER_LBL);

        for (String notifier : allNotifiers) {
            JMenuItem extensionItem = new JMenuItem(notifier);
            if (currentNotifiers.contains(notifier)) {
                extensionItem.setEnabled(FALSE);
            } else {
            	extensionItem.addActionListener(e -> controller.useExtension(notifier));
            }
            useExtensionMenu.add(extensionItem);
        }
        return useExtensionMenu;
    }

    @Override
    public void update(Object message) {
        showNotification((String) message, FALSE);
    }
}