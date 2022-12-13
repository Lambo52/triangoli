import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class appPanel extends JPanel implements Runnable {
    double drawInterval;
    double delta;
    long lastTime;
    long currentTime;
    MouseEvent mouseClicked;
    int FPS = 60;
    mouseInputs mouseListener = new mouseInputs(this);
    Thread gameThread; //gameThread è il thread principale per il loop
    boolean running = false; //serve per non far ripartire la thread
    Graphics g;
    Point[] point = new Point[3];
    Point point1 = new Point(100, 690);
    Point point2 = new Point(900, 690);
    Point point3 = new Point(500, 10);
    Point newPoint = new Point();
    Point randomPoint = new Point();
    boolean startLoop = false;

    private static final int POINT_WIDTH = 5;
    private static final int POINT_HEIGHT = 5;

    public appPanel() {
        this.setPreferredSize(new Dimension(1000, 700)); //dimensioni pannello
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

    public void startThread() {
        if (running) {
            return; //ritorna se la thread è gia partita e non riparte 2 volte, per sicurezza
        }
        running = true;
        gameThread = new Thread(this); //qui si inizializza il Thread
        gameThread.start(); //questo chiama il metodo run direttamente
    }

    @Override
    public void run() { //metodo generato automaticamente da runnable

        /*drawInterval = 1000000000/FPS;
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
        }*/
        while (true) {
            paint(g);
        }
    }

    public void paint(Graphics g) {
        g = getGraphics();
        g.setColor(Color.black);
        g.fillOval(point1.x - POINT_WIDTH / 2 - 1, point1.y - POINT_HEIGHT / 2 - 1, POINT_WIDTH, POINT_HEIGHT);
        g.fillOval(point2.x - POINT_WIDTH / 2 - 1, point2.y - POINT_HEIGHT / 2 - 1, POINT_WIDTH, POINT_HEIGHT);
        g.fillOval(point3.x - POINT_WIDTH / 2 - 1, point3.y - POINT_HEIGHT / 2 - 1, POINT_WIDTH, POINT_HEIGHT);
        if (startLoop) {
            //così disegna il primo punto
            //lo commento perché se il primo punto è in una zona che deve rimanere bianca poi fa schifo
            //g.fillRect(newPoint.x, newPoint.y, POINT_WIDTH, POINT_HEIGHT);
            Random random = new Random();
            int i = random.nextInt(3);
            randomPoint = point[i];
            newPoint.x = (int) (newPoint.x + randomPoint.x) / 2;
            newPoint.y = (int) (newPoint.y + randomPoint.y) / 2;
            g.fillOval(newPoint.x - POINT_WIDTH / 2 - 1, newPoint.y - POINT_HEIGHT / 2 - 1, POINT_WIDTH, POINT_HEIGHT);
        }
        g.dispose();
    }

    public void mouseClicked(MouseEvent e) {
        //se il loop è iniziato non faccio nulla quando clicco con il mouse
        if (!startLoop) {
            mouseClicked = e;
            newPoint.x = e.getX();
            newPoint.y = e.getY();
            boolean bool = PointInTriangle(newPoint, point1, point2, point3);
            if (PointInTriangle(newPoint, point1, point2, point3)) {
                startLoop = true;
            } else {
                System.out.println("Devi cliccare all'interno del triangolo scemo");
            }
        }
    }

    //funzioni per controllare se il punto dato è all'interno del triangolo
    float sign(Point p1, Point p2, Point p3) {
        return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
    }

    boolean PointInTriangle(Point pt, Point v1, Point v2, Point v3) {
        float d1, d2, d3;
        boolean has_neg, has_pos;
        d1 = sign(pt, v1, v2);
        d2 = sign(pt, v2, v3);
        d3 = sign(pt, v3, v1);
        has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
        has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);
        return !(has_neg && has_pos);
    }
}