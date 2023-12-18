package Logik;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import Materials.Base.*;
import Materials.Model.*;

public class Game extends JFrame{
    //Finals
    final static int WIDTH = 40;
    final static int HEIGHT = 40;
    final static int WIDTHMODIFIER = 10;
    final static int HEIGHTMODIFIER = 10;
    final static int DELAY = 80;

    //Ui Variables
    GameMouseListener MouseListener;
    GameKeyListener KeyListener;
    private BufferedImage buffer;

    //Game Variables
    boolean running = true;
    MaterialBase[][] itemMap;
    Color[][] colorMap;
    Timer timer;
    MaterialBrush Brush;

    public Game(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Initialize();
            }
        }); 

        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Loop();
            }
        });

        startLoop();
    }

    /**
     * Starts the game loop.
     */
    public void startLoop() {
        System.out.println("Starting loop");

        timer.start();
    }

    /**
     * Sets up the Enviroment
     */
    public void Initialize(){
        InitializeGameVariables();

        MouseListener = new GameMouseListener(this, WIDTHMODIFIER, HEIGHTMODIFIER);
        this.addMouseListener(MouseListener);

        KeyListener = new GameKeyListener(Brush);
        this.addKeyListener(KeyListener);

        CreateGui(); 
    }

    /**
     * Creates the Gui
     */
    private void CreateGui(){
        setTitle("MaterialsInMotion Pre Alpha");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH*WIDTHMODIFIER, HEIGHT*HEIGHTMODIFIER);

        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

        setFocusable(true);
        requestFocusInWindow();
        setVisible(true);
    }

    /**
     * Initializes game variables
     */
    private void InitializeGameVariables(){
        Brush = new MaterialBrush();

        itemMap = new MaterialBase[HEIGHT][WIDTH];
        colorMap = new Color[HEIGHT][WIDTH];


        for(int rowIndex = 0; rowIndex < HEIGHT; rowIndex++){

            for(int collumnIndex = 0; collumnIndex < WIDTH; collumnIndex++){

                itemMap[rowIndex][collumnIndex] = new Air(collumnIndex, rowIndex);

                colorMap[rowIndex][collumnIndex] = itemMap[rowIndex][collumnIndex].BaseColor;
            }
        }
    }

    /**
     * Main gameloop
     */
    private void Loop(){
        //System.out.println("Loop");
        updateMap();

        updateColorMap();

        repaint();
    }

    private void updateMap() {
        //TODO
        int xIndex = 0;
        int yIndex = 0;
        boolean allhandled = false;

        while(!allhandled){
            allhandled = true;

            for(int row = yIndex; row < itemMap.length; row++){
                for(int collumn = xIndex; collumn < itemMap[row].length; collumn++){

                    if(!itemMap[row][collumn].isHandled){

                        allhandled = false;

                        itemMap = itemMap[row][collumn].Update(itemMap);

                        colorMap[row][collumn] = itemMap[row][collumn].BaseColor;

                        collumn --;
                    }
                }
            }
        }

        for(int row = yIndex; row < itemMap.length; row++){
            for(int collumn = xIndex; collumn < itemMap[row].length; collumn++){
                itemMap[row][collumn].isHandled = false;
            }
        }
    }

    private void updateColorMap(){
        for(int row = 0; row < itemMap.length; row++){
            for(int collumn = 0; collumn < itemMap[row].length; collumn++){

                  colorMap[row][collumn] = itemMap[row][collumn].BaseColor;

            }
        }
    }

    public void spawnMaterial(int xCord, int yCord){
        MaterialBase tempMaterial = new Sand(xCord, yCord);

        switch(Brush.Material){
            case Sand: 
                tempMaterial = new Sand(xCord, yCord);
                break;
            case Water: 
                tempMaterial = new Water(xCord, yCord);
                break;
            case Air: 
                tempMaterial = new Air(xCord, yCord);
                break;
        }

        itemMap[yCord][xCord] = tempMaterial;

        colorMap[yCord][xCord] = tempMaterial.BaseColor;

    }

    @Override
    public void paint(java.awt.Graphics g) {
        Graphics2D bufferGraphics = (Graphics2D) buffer.getGraphics();

        // Clear the off-screen image
        bufferGraphics.setColor(getBackground());
        bufferGraphics.fillRect(0, 0, getWidth(), getHeight());

        // Draw on the off-screen image
        for (int row = 0; row < colorMap.length; row++) {
            for (int collumn = 0; collumn < colorMap[row].length; collumn++) {

                bufferGraphics.setColor(colorMap[row][collumn]);

                bufferGraphics.fillRect(collumn * WIDTHMODIFIER, row * HEIGHTMODIFIER, WIDTHMODIFIER, HEIGHTMODIFIER);

            }
        }
        // Copy the off-screen image to the screen
        g.drawImage(buffer, 0, 0, this);
    }
}
