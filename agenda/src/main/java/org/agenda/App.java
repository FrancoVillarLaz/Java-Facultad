package org.agenda;


import org.agenda.gui.LoginGui;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginGui login = new LoginGui();
            login.setVisible(true); // Mostrar la ventana de login
        });
    }
    }

