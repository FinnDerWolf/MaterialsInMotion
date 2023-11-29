package Materials.Model;
import java.awt.Color;

import Materials.Base.GasBase;

public class Air extends GasBase{

    public Air(int xCord, int yCord){
        super(xCord, yCord);

        this.name = "Air";
        this.density = 1.225;
        this.BaseColor = new Color(162, 241, 245);
    }
}
