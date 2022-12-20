import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlPanelClass implements ActionListener {
    JPanel pannello;
    loopPanelClass loop;
    JButton buttonStop;
    JButton buttonContinue;
    JButton buttonReset;
    public controlPanelClass(JPanel panel, loopPanelClass loopPanel) {
        this.pannello = panel;
        this.loop = loopPanel;

        panel.setBounds(0,0,200,700);
        panel.setBackground(Color.lightGray);
        panel.setLayout(null);

        buttonStop = new JButton("stop");
        buttonStop.setBounds(50,200,100,50);
        pannello.add(buttonStop);
        buttonStop.addActionListener(this);

        buttonContinue = new JButton("continue");
        buttonContinue.setBounds(50,300,100,50);
        pannello.add(buttonContinue);
        buttonContinue.addActionListener(this);

        buttonReset = new JButton("reset");
        buttonReset.setBounds(50,400,100,50);
        pannello.add(buttonReset);
        buttonReset.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonStop) {
            loop.setStop(true);
        }
        else if(e.getSource() == buttonContinue) {
            loop.setStop(false);
        }
        else if(e.getSource() == buttonReset) {
            loop.resetAll();
        }
    }
}
