import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlPanelClass extends JPanel {
    loopPanelClass loop;
    JButton buttonStop;
    JButton buttonContinue;
    JButton buttonReset;
    public controlPanelClass(loopPanelClass loopPanel) {

        this.loop = loopPanel;

        this.setBounds(0,0,200,700);
        this.setBackground(Color.lightGray);
        this.setLayout(null);

        buttonStop = new JButton("stop");
        buttonStop.setBounds(50,200,100,50);
        this.add(buttonStop);
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loop.setStop(true);
            }
        });

        buttonContinue = new JButton("continue");
        buttonContinue.setBounds(50,300,100,50);
        this.add(buttonContinue);
        buttonContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loop.setStop(false);
            }
        });

        buttonReset = new JButton("reset");
        buttonReset.setBounds(50,400,100,50);
        this.add(buttonReset);
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loop.resetAll();
            }
        });

    }
}
