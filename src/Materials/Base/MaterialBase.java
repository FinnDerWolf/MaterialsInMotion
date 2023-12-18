package Materials.Base;

import java.awt.Color;

public abstract class MaterialBase {
    public String Name;
    public int xCord;
    public int yCord;
    public double density;
    public boolean isHandled;
    public Color BaseColor;
    public AggregateStates state;

    enum AggregateStates {
        solid,
        liquid,
        gaseous
    }

    public MaterialBase(int xCord, int yCord){
        this.xCord = xCord;
        this.yCord = yCord;
        isHandled = false;
    }

    public abstract MaterialBase[][] Update(MaterialBase[][] map);
}
