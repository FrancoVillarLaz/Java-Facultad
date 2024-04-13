package VentanaPractica;

import javax.swing.*;

public class Ventana {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Juego Cartas v1");//titulo de la ventana
        ventana.setSize(300,300);//dimensiones de la ventana
        ventana.setVisible(true); //muestra la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Apretar aca para cerrar la ventanaa
    }
}
