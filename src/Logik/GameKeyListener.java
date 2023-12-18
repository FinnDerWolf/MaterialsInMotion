package Logik;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameKeyListener extends KeyAdapter{
    public MaterialBrush influencedBrush;

    enum Materials {
        Sand,
        Air,
        Water
    }

    public GameKeyListener(MaterialBrush brush){
        this.influencedBrush = brush;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle key presses
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case 49:
                influencedBrush.setMaterial(Materials.Sand);
                break;
            case 50:
                influencedBrush.setMaterial(Materials.Water);
                break;
            case 51:
                influencedBrush.setMaterial(Materials.Air);
                break;
        }
    }
}
