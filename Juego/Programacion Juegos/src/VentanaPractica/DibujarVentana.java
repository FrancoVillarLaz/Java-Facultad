package VentanaPractica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class DibujarVentana extends JPanel{
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;//puntero
        g2d.setColor(Color.RED); //selecciona color rojo
        g2d.fillOval(0, 0, 30, 30); //pinta un circulo
        g2d.drawOval(0, 50, 30, 30);//dinuja un circulo
        g2d.fillRect(50, 0, 30, 30);//pinta un cuadrado
        g2d.drawRect(50, 50, 30, 30);//dibuja un cuadrado

        g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));//tmbn dibuja un circulo
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Mini Tennis");
        ventana.add(new DibujarVentana());
        ventana.setSize(300, 300);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
