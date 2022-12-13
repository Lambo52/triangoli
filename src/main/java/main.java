import javax.swing.JFrame;

public class main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false); //no ridimensionamento
        window.setTitle("Triangoli magici");
        window.setUndecorated(false);

        appPanel Panel = new appPanel();
        window.add(Panel); //aggiunge il panel alla finestra
        window.pack(); // incrementa le performances
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        Panel.startThread(); //qui inizializza il thread (loop principale)

    }
}