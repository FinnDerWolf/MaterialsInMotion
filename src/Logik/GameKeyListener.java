package Logik;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Logik.MaterialBrush.Materials;

public class GameKeyListener extends KeyAdapter{
    public MaterialBrush influencedBrush;

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
            case 52:
                influencedBrush.setMaterial(Materials.Stone);
                break;
            case 53:
                influencedBrush.setMaterial(Materials.Oil);
                break;
            case KeyEvent.VK_UP:
                influencedBrush.increaseSize();
                break;
            case KeyEvent.VK_DOWN:
                influencedBrush.decreaseSize();
                break;
        }
    }
}
