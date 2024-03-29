package Logik;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameMouseListener implements MouseListener, MouseMotionListener{
    private final Game parent;

    public int widthModifier;
    public int heightModifier;
    
    public GameMouseListener(Game parent, int widthModifier, int heightModifier){
        this.parent = parent;

        this.widthModifier = widthModifier;
        this.heightModifier = heightModifier;
    }
    //Interface implementation
    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("Mouse " + e.getClickCount() + " times clicked at "
        //        + e.getPoint());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        var x = (int)Math.floor(e.getX() / widthModifier);
        var y = (int)Math.floor(e.getY()/ heightModifier);

        parent.useBrush(x, y);

        System.out.println("("+x +"|"+ y +") "+ e.getPoint());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        var x = (int)Math.floor(e.getX() / widthModifier);
        var y = (int)Math.floor(e.getY()/ heightModifier);

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
