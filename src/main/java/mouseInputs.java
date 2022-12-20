import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class mouseInputs implements MouseListener, MouseMotionListener {
    loopPanelClass aP;
    public mouseInputs(loopPanelClass appPanel) {
        this.aP = appPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        aP.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
