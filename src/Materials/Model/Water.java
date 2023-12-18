package Materials.Model;

import java.awt.Color;

import Materials.Base.LiquidBase;

public class Water extends LiquidBase{
    
    public Water(int xCord, int yCord){
        super(xCord, yCord);

        this.Name = "Water";
        this.BaseColor = new Color(40, 130, 219);
        this.density = 5.0;
    }
}
