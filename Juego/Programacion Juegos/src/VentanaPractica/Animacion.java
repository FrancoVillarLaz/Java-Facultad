package VentanaPractica;

import javax.swing.*;
import java.awt.*;

public class Animacion extends JPanel {
    int x = 0;
    int y = 0;

    private void moverCirculo(){
        x+=1;
        y+=1;
    }
    @Override
    public void paint(Graphics g){
        super.paint(g); //metodo heredadio que borra la pantalla
        Graphics2D g2d = (Graphics2D) g; // puntero
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);//Elimina bordes de cierra
        g2d.fillOval(x,y,30,30);//imprime el circulo
    }

    public static void main(String[] args) throws  InterruptedException{
        JFrame ventana = new JFrame("MiniTenis");
        Animacion anim = new Animacion();
        ventana.add(anim);
        ventana.setSize(300,400);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true){
            anim.moverCirculo();
            anim.repaint();
            Thread.sleep(10);
            //dar descanso al hilo, permite liberar
            //el hilo para que pueda ser utilizado por los otros
        }
    }
}
