package org.agenda.gui;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

    private JLabel userNameLabel;
    private JLabel userPhotoLabel;

    public Gui() {
        super("MSN Messenger");

        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Panel para la foto de usuario
        JPanel userPhotoPanel = new JPanel();
        userPhotoPanel.setBackground(new Color(0, 102, 204)); // Color azul
        userPhotoPanel.setPreferredSize(new Dimension(100, 100)); // Tamaño fijo para la foto
        userPhotoLabel = new JLabel();
        userPhotoPanel.add(userPhotoLabel);
        mainPanel.add(userPhotoPanel, BorderLayout.NORTH);

        // Panel para el nombre de usuario
        JPanel userNamePanel = new JPanel();
        userNamePanel.setBackground(new Color(0, 102, 204)); // Color azul
        userNamePanel.setPreferredSize(new Dimension(100, 30)); // Altura fija para el nombre de usuario
        userNameLabel = new JLabel();
        userNameLabel.setForeground(Color.WHITE); // Texto en blanco
        userNamePanel.add(userNameLabel);
        mainPanel.add(userNamePanel, BorderLayout.SOUTH);

        // Lista de contactos
        DefaultListModel<String> contactListModel = new DefaultListModel<>();
        JList<String> contactList = new JList<>(contactListModel);
        JScrollPane scrollPane = new JScrollPane(contactList);

        // Establecer la apariencia de la lista de contactos
        contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Agregar la lista de contactos al panel principal
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Establecer el panel principal como contenido de la ventana
        setContentPane(mainPanel);

        // Llamar a los métodos para cargar los datos desde la base de datos
        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        // Llamar al método para cargar los datos del usuario
        loadUserDataFromDatabase();
        // Llamar al método para cargar los contactos del usuario
        loadContactsFromDatabase();
    }

    private void loadUserDataFromDatabase() {
        // Aquí se llamaría al método que carga los datos del usuario desde la base de datos
        // Por ejemplo: DataManager.loadUserData();
    }

    private void loadContactsFromDatabase() {
        // Aquí se llamaría al método que carga los contactos del usuario desde la base de datos
        // Por ejemplo: DataManager.loadContacts();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Gui gui = new Gui();
            gui.setVisible(true); // Mostrar la ventana
        });
    }
}
