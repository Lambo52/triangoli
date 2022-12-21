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

        loopPanelClass loopPanel = new loopPanelClass();


        window.add(loopPanel);

        controlPanelClass controlpanelclass = new controlPanelClass(loopPanel);
        window.add(controlpanelclass);
        window.pack(); // incrementa le performances
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        loopPanel.startThread(); //qui inizializza il thread (loop principale)
        //loopPanel.startOtherThread();

    }
}
