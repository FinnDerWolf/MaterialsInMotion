package Materials.Model;
import java.awt.Color;

import Materials.Base.SolidBase;

public class Sand extends SolidBase{
    
    public Sand(int xCord, int yCord){
        super(xCord, yCord);

        this.name = "Sand";
        this.density = 1602.0;
        this.BaseColor = new Color(242, 209, 109);
    }
}
