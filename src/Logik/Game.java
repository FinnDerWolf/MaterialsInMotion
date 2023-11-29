package Logik;
import java.awt.*;

import javax.swing.*;

import Materials.Base.*;
import Materials.Model.*;

public class Game {
    //Finals
    final int Width;
    final int Height;
    final GridLayout Layout;

    //Ui Variables
    JFrame frame;
    Container conentPane;
    Canvas mainCanvas;
    Graphics graphics;

    //Game Variables
    boolean running = true;
    MaterialBase[][] itemMap;
    Color[][] colorMap;
    MaterialBase[] unhandledFields;
    MaterialBase[] handledFields;
 
    public Game(int width, int height){
        Height = height;
        Width = width;
        Layout = new GridLayout(Height, Width);
    }

    /**
     * Run this instance of Game
     */
    public void Run(){
        CreateGui(); 

        InitializeGameVariables();
        
        StartLoop();
    }

    /**
     * 
     */
    private void CreateGui(){
        frame = new JFrame();
        conentPane = frame.getContentPane();
        mainCanvas = new Canvas();
        mainCanvas.setBackground(new Color(222));
        this.conentPane.add(mainCanvas);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Width*10, Height*10);
        frame.setVisible(true);
    }

    /**
     * 
     */
    private void InitializeGameVariables(){
        itemMap = new MaterialBase[Height][Width];
        colorMap = new Color[Height][Width];
        unhandledFields = new MaterialBase[Width * Height];
        handledFields = new MaterialBase[Width * Height];


        for(int rowIndex = 0; rowIndex < Height; rowIndex++){

            for(int collumnIndex = 0; collumnIndex < Width; collumnIndex++){

                itemMap[rowIndex][collumnIndex] = new Air(collumnIndex, rowIndex);

                colorMap[rowIndex][collumnIndex] = itemMap[rowIndex][collumnIndex].BaseColor;

                unhandledFields = (MaterialBase[]) AddToArray(handledFields, itemMap[rowIndex][collumnIndex]);
            }
        }
    }

    private void StartLoop(){
        while(running){
            Loop();
        }
    }

    private void Loop(){
        handleInputs();

        updateMap();

        updateGraphics();
        //TODO
        //wait(1000.0);
    }

    private void updateGraphics() {
        mainCanvas.

        for(int rowIndex = 0; rowIndex < Height; rowIndex++){

            for(int collumnIndex = 0; collumnIndex < Width; collumnIndex++){
                
                if(colorMap[rowIndex][collumnIndex] != itemMap[rowIndex][collumnIndex].BaseColor){

                   colorMap[rowIndex][collumnIndex] = itemMap[rowIndex][collumnIndex].BaseColor;

                }
                JPanel tempPanel = new JPanel();
                tempPanel.setBackground(colorMap[rowIndex][collumnIndex]);
                mainCanvas.add(tempPanel, (rowIndex * Width + collumnIndex));
            }
        }
    }

    private void updateMap() {
        return;
    }

    private void handleInputs() {
        return;
    }

    private Object[] AddToArray(Object[] arr, Object item){
        try{
            for(int i = 0; i<arr.length; i++) {

                if(arr[i] == null)
                {
                    arr[i] = item;
                    break;
                }

            }
            return arr;
        }
        catch(Exception e){
            return arr;
        }
    }
}
