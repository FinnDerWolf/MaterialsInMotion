package Logik;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameMouseListener implements MouseListener, MouseMotionListener{
    private final Game parent;

    // public int widthModifier;
    // public int heightModifier;
    
    public GameMouseListener(Game parent) {
    this.parent = parent;
    }
    //Interface implementation
    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("Mouse " + e.getClickCount() + " times clicked at "
        //        + e.getPoint());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int cellWidth = parent.getWidth() / Game.WIDTH;
        int cellHeight = parent.getHeight() / Game.HEIGHT;

        int x = e.getX() / cellWidth;
        int y = e.getY() / cellHeight;

        parent.useBrush(x, y);

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int cellWidth = parent.getWidth() / Game.WIDTH;
        int cellHeight = parent.getHeight() / Game.HEIGHT;

        int x = e.getX() / cellWidth;
        int y = e.getY() / cellHeight;

        parent.useBrush(x, y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("Mouse " + e.getClickCount() + " times released at "
        //        + e.getPoint());
    }

    @Override   
    public void mouseEntered(MouseEvent e) {
        //System.out.println("Mouse entered at " + e.getPoint());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("Mouse exited at " + e.getPoint());
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}
