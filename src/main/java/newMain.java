import javax.swing.*;
import java.awt.*;

public class newMain {
    public newMain() {
        JFrame window = new JFrame();
        window.setPreferredSize(new Dimension(1200,740));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false); //no ridimensionamento
        window.setTitle("Triangoli magici");
        window.setUndecorated(false);
        window.setResizable(false); //jijijiha
        window.setLayout(null);

        JPanel loopPanel = new JPanel();
        loopPanel.setBounds(200,0,1000,700);
        loopPanel.setBackground(Color.white);
        window.add(loopPanel);

        JPanel controlPanel = new JPanel();
        window.add(controlPanel);


        loopPanelClass looppanelclass = new loopPanelClass();
        loopPanel.add(looppanelclass); //aggiunge il panel alla finestra

        controlPanelClass controlpanelclass = new controlPanelClass(controlPanel,looppanelclass);

        window.pack(); // incrementa le performances
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        looppanelclass.startThread(); //qui inizializza il thread (loop principale)

    }
}
