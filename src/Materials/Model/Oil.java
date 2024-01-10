package Materials.Model;

import java.awt.Color;

import Materials.Base.LiquidBase;

public class Oil extends LiquidBase{
    
    public Oil(int xCord, int yCord){
        super(xCord, yCord);

        this.Name = "Oil";
        this.BaseColor = new Color(0, 0, 0);
        this.density = 3.0;
    }
}

