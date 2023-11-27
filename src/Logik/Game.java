package Logik;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {
    //Finals
    final int Width;
    final int Height;
    final GridLayout Layout;

    //Ui Variables
    JFrame frame;
    Container conentPane;
    JPanel mainPanel;

    //Variables
    boolean running = true;

    public Game(int width, int height){
        Height = height;
        Width = width;
        Layout = new GridLayout(Height, Width);
    }

    public void Run(){
        CreateGui(); 
        
        StartLoop();

    }

    private void CreateGui(){
        frame = new JFrame();
        conentPane = frame.getContentPane();
        mainPanel = new JPanel(Layout);
        mainPanel.setBackground(new Color(222));
        this.conentPane.add(mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Width*10, Height*10);
        frame.setVisible(true);
    }

    private void StartLoop(){

        while(running){
            Loop();
        }
    }

    private void Loop(){

    }
}
