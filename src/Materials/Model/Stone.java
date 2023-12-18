package Materials.Model;

import java.awt.Color;

import Materials.Base.ImovableBase;

public class Stone extends ImovableBase{
    
    public Stone(int xCord, int yCord){
        super(xCord, yCord);

        this.Name = "Stone";
        this.BaseColor = new Color(97, 97, 97);
        this.density = 5000.0;
    }
}
