package org.agenda.gui;
import org.agenda.servicios.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGui extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField correoField;

    public LoginGui() {
        super("Login");

        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false); // Evita que se pueda cambiar el tamaño de la ventana

        // Crear paneles
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(59, 89, 152)); // Color de fondo azul

        // Campo de usuario
        JPanel usernamePanel = new JPanel();
        usernamePanel.setBackground(new Color(59, 89, 152)); // Color de fondo azul
        JLabel usernameLabel = new JLabel("Usuario:");
        usernameLabel.setForeground(Color.WHITE); // Texto blanco
        usernameField = new JTextField(15);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        mainPanel.add(usernamePanel);

        // Campo de correo
        JPanel correoPanel = new JPanel();
        usernamePanel.setBackground(new Color(59, 89, 152)); // Color de fondo azul
        JLabel correoLabel = new JLabel("Correo:");
        correoLabel.setForeground(Color.WHITE); // Texto blanco
        correoField = new JTextField(15);
        correoPanel.add(correoLabel);
        correoPanel.add(correoField);
        mainPanel.add(correoPanel);

        // Campo de contraseña
        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(new Color(59, 89, 152)); // Color de fondo azul
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setForeground(Color.WHITE); // Texto blanco
        passwordField = new JPasswordField(15);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        mainPanel.add(passwordPanel);

        // Botón de inicio de sesión
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBackground(new Color(0, 102, 204)); // Color de fondo azul más oscuro
        loginButton.setForeground(Color.WHITE); // Texto blanco

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí se verificarían las credenciales ingresadas
                String username = usernameField.getText();
                String correo = correoField.getText();
                char[] password = passwordField.getPassword();

                Login login= new Login(username,password,correo);
                boolean logeado = login.logear();
                 if (logeado == true) {
                     JOptionPane.showMessageDialog(LoginGui.this, "Se logeo correctamente", "Inicio de sesión", JOptionPane.INFORMATION_MESSAGE);

                     // Si las credenciales son válidas, se abriría la ventana principal
                    //openMainWindow();
                     // Y se cierra la ventana de login
                     dispose();
                 } else {
                     // Si las credenciales son inválidas, se muestra un mensaje de error
                     JOptionPane.showMessageDialog(LoginGui.this, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                 }
            }
        });
        mainPanel.add(loginButton);

        // Agregar el panel principal al contenido de la ventana
        setContentPane(mainPanel);
    }

    // Método para abrir la ventana principal
    // private void openMainWindow() {
    //     MSNGui gui = new MSNGui();
    //     gui.setVisible(true);
    // }

    public static void main(String[] args) {
        // Ejecutar la aplicación
        SwingUtilities.invokeLater(() -> {
            LoginGui login = new LoginGui();
            login.setVisible(true); // Mostrar la ventana de login
        });
    }
}
