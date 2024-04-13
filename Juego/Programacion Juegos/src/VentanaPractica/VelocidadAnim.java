package VentanaPractica;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VelocidadAnim extends JPanel {
    int x = 0;
    int y = 0;
    int xa = 1; //direccion y velocidad
    //xa = 1 derecha - aumentando el valor aumenta la velocidad
    //xa = -1 izquierda - aumentando el valor aumenta la velocidad
    int ya = 1; //
    //ya = 1 abajo
    //ya = -1 arriba


    private void moverPelota() {
        if (x + xa < 0)
            xa = 5;
        if (x + xa > getWidth() - 30) // para evitar que salga de la pantalla cambia la direccion de la pelota
            xa = -5;
        if (y + ya < 0)
            ya = 5;
        if (y + ya > getHeight() - 30)
            ya = -5;

        x = x + xa;
        y = y + ya;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.fillOval(x, y, 30, 30);

    }

    public static void main(String[] args) throws InterruptedException {
        JFrame ventana = new JFrame("Mini Tennis");
        VelocidadAnim velo = new VelocidadAnim();
        ventana.add(velo);
        ventana.setSize(300, 400);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            velo.moverPelota();
            velo.repaint();
            Thread.sleep(10);
        }
    }
}
