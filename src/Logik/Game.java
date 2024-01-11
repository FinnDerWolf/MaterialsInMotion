package Logik;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Materials.Base.*;
import Materials.Model.*;

public class Game extends JFrame{
    //Finals
    final static String TITLE = "Materials in Motion / prototype 1";
    final static int WIDTH = 100;
    final static int HEIGHT = 100;
    final static int WIDTHMODIFIER = 8;
    final static int HEIGHTMODIFIER = 8;
    final static int DELAY = 20;

    //Ui Variables
    private GameMouseListener mouseListener;
    private GameKeyListener keyListener;

    //Game Variables
    boolean running = true;
    MaterialBase[][] itemMap;
    Color[][] colorMap;
    Timer timer;
    MaterialBrush brush;

    private boolean temp;

    public Game(boolean t){
        temp = t;
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                executeLoop();
            }
        });
    }

    /**
     * Run this instane of game
     */
    public void run(){
        initialize();
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
    public void initialize(){
        initializeGameVariables();

        mouseListener = new GameMouseListener(this, WIDTHMODIFIER, HEIGHTMODIFIER);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);

        keyListener = new GameKeyListener(brush);
        this.addKeyListener(keyListener);

        createGui(); 
    }

    /**
     * Creates the Gui
     */
    private void createGui(){
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH*WIDTHMODIFIER, HEIGHT*HEIGHTMODIFIER);

        setFocusable(true);
        requestFocusInWindow();
        setVisible(true);
    }

    /**
     * Initializes game variables
     */
    private void initializeGameVariables(){
        brush = new MaterialBrush();

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
    private void executeLoop(){
        //System.out.println("Loop");
        updateMap();

        updateColorMap();

        repaint();
    }

    /**
     * Updates the itemMap
     */
    private void updateMap() {
        //TODO Make more efficient
        int yIndexMax = itemMap.length - 1;
        int xIndexMax = itemMap[0].length - 1;
        boolean allhandled = false;

        //top to buttom
        if(temp){
            while(!allhandled){
                allhandled = true;

                //Top to bottom
                for(int row = 0; row < itemMap.length; row++){

                    var randomInt = Math.round(Math.random());

                    if(randomInt > 0){
                        //left to right
                        for(int collumn = 0; collumn < itemMap[row].length; collumn++){

                            if(!itemMap[row][collumn].isHandled){

                                allhandled = false;

                                itemMap = itemMap[row][collumn].Update(itemMap);

                                colorMap[row][collumn] = itemMap[row][collumn].BaseColor;

                                collumn --;
                            }
                        }
                    }
                    else{
                        //left to right
                        for(int collumn = xIndexMax; collumn >= 0; collumn--){

                            if(!itemMap[row][collumn].isHandled){

                                allhandled = false;

                                itemMap = itemMap[row][collumn].Update(itemMap);

                                colorMap[row][collumn] = itemMap[row][collumn].BaseColor;

                                collumn ++;
                            }
                        }
                    }
                }
            }
        }
        //Buttom to top
        else{

            while(!allhandled){
                allhandled = true;

                for(int row = yIndexMax; row >= 0; row--){
                    for(int collumn = xIndexMax; collumn >= 0; collumn--){

                        if(!itemMap[row][collumn].isHandled){

                            allhandled = false;

                            itemMap = itemMap[row][collumn].Update(itemMap);

                            colorMap[row][collumn] = itemMap[row][collumn].BaseColor;

                            collumn ++;
                        }
                    }
                }
            }
        }

        for(int row = 0; row < itemMap.length; row++){
            for(int collumn = 0; collumn < itemMap[row].length; collumn++){
                itemMap[row][collumn].isHandled = false;
            }
        }
    }

    /**
     * Updates the colorMap
     */
    private void updateColorMap(){
        for(int row = 0; row < itemMap.length; row++){
            for(int collumn = 0; collumn < itemMap[row].length; collumn++){

                  colorMap[row][collumn] = itemMap[row][collumn].BaseColor;

            }
        }
    }

    /**
     * Places materials at a certain location using the brushes parameters
     */
    public void useBrush(int xCord, int yCord){
        MaterialBase tempMaterial = new Sand(xCord, yCord);

        
        
        //TODO Handle brush size
        for(int rowIndex = yCord - brush.size; rowIndex <= yCord + brush.size; rowIndex++){
            for(int collumnIndex = xCord - brush.size; collumnIndex <= xCord + brush.size; collumnIndex++){
                //check if field exists
                if(rowIndex > itemMap.length-1 || rowIndex < 0 || collumnIndex > itemMap[0].length-1 || collumnIndex < 0){
                    continue;
                }

                //Create new material
                switch(brush.material){
                    case Sand: 
                        tempMaterial = new Sand(collumnIndex, rowIndex);
                        break;
                    case Water: 
                        tempMaterial = new Water(collumnIndex, rowIndex);
                        break;
                    case Air: 
                        tempMaterial = new Air(collumnIndex, rowIndex);
                        break;
                    case Stone: 
                        tempMaterial = new Stone(collumnIndex, rowIndex);
                        break;
                    case Oil: 
                        tempMaterial = new Oil(collumnIndex, rowIndex);
                        break;
                }
                //spawn material in right place
                itemMap[rowIndex][collumnIndex] = tempMaterial;

                //colorMap[rowIndex][collumnIndex] = tempMaterial.BaseColor;
            }
        }
        //itemMap[yCord][xCord] = tempMaterial;

        //colorMap[yCord][xCord] = tempMaterial.BaseColor;

    }

    @Override
    public void paint(java.awt.Graphics g) {
        //TODO switch to using buffer graphics?
        for (int row = 0; row < colorMap.length; row++) {
            for (int collumn = 0; collumn < colorMap[row].length; collumn++) {

                g.setColor(colorMap[row][collumn]);

                g.fillRect(collumn * WIDTHMODIFIER, row * HEIGHTMODIFIER, WIDTHMODIFIER, HEIGHTMODIFIER);
            }
        }
    }
}
