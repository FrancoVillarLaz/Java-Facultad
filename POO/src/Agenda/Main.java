package Agenda;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame ventana = new AgendaGUI();
                ventana.setSize(600,400);
                ventana.setVisible(true);
            }
        });
    }
}
