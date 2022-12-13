
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class appPanel extends JPanel implements Runnable{

    double drawInterval;
    double delta;
    long lastTime;
    long currentTime;
    MouseEvent mouseClicked;
    int FPS = 1000;
    mouseInputs mouseListener = new mouseInputs(this);
    Thread gameThread; //gameThread è il thread principale per il loop
    boolean running = false; //serve per non far ripartire la thread

    Graphics g;

    Point[] point = new Point[3];
    Point point1 = new Point(100,690);
    Point point2 = new Point(900,690);
    Point point3 = new Point(500,10);
    Point newPoint = new Point();
    Point randomPoint = new Point();

    boolean startLoop = false;

    public appPanel() {
        this.setPreferredSize(new Dimension(1000,700)); //dimensioni pannello

        this.setBackground(Color.white);
        this.setDoubleBuffered(true); //incrementa le performances (in realtà non serve a niente)

        this.addMouseListener(mouseListener); //implementa i clic del mouse
        this.addMouseMotionListener(mouseListener); //implementa i movimenti del mouse

        this.requestFocus();// dovrebbe servire per il mouse ma funziona anche senza dato che c'è setFocusable
        this.setFocusable(true);
        point[0] = point1;
        point[1] = point2;
        point[2] = point3;

    }


   public void startThread(){

        if (running) {
            return; //ritorna se la thread è gia partita e non riparte 2 volte, per sicurezza
        }
        running = true;
        gameThread = new Thread(this); //qui si inizializza in Thread
        gameThread.start(); //questo chiama il metodo run direttamente
    }


    @Override
    public void run() { //metodo generato automaticamente da runnable
/*
        drawInterval = 1000000000/FPS;
        delta = 0;
        lastTime = System.nanoTime();
        //long currentTime;
        while (gameThread != null) {

            currentTime = System.nanoTime(); // misura in miliardo di nanosecondi
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                paint(g);
                delta--;
            }
        }
*/

        while(true) {
            paint(g);
        }

    }



    public void paint(Graphics g) {
        g = getGraphics();
        g.setColor(Color.black);
/*
        g.fillRect(point1.x,point1.y,1,1);
        g.fillRect(point2.x,point2.y,1,1);
        g.fillRect(point3.x, point3.y, 1,1);
  */
        g.fillOval(point1.x - 3,point1.y - 3,5,5);
        g.fillOval(point2.x - 3,point2.y - 3,5,5);
        g.fillOval(point3.x - 3,point3.y - 3,5,5);

        if(startLoop) {
            Random random = new Random();
            int i = random.nextInt(3);
            randomPoint = point[i];

            newPoint.x = (int) (newPoint.x + randomPoint.x) / 2;
            newPoint.y = (int) (newPoint.y + randomPoint.y) / 2;

            //g.fillRect(newPoint.x, newPoint.y, 1,1);

            g.fillOval(newPoint.x - 3, newPoint.y - 3,5,5);
        }


        g.dispose();


    }

    public void mouseClicked(MouseEvent e) {
        mouseClicked = e;
        newPoint.x = e.getX();
        newPoint.y = e.getY();
        startLoop = true;
    }

}