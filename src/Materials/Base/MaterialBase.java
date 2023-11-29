package Materials.Base;

import java.awt.Color;

public abstract class MaterialBase {
    public String name;
    public int xCord;
    public int yCord;
    public double density;
    public AggregateStates state;
    public Color BaseColor;

    enum AggregateStates {
        solid,
        liquid,
        gaseous
    }

    public MaterialBase(int xCord, int yCord){
        this.xCord = xCord;
        this.yCord = yCord;
    }

    public abstract MaterialBase[][] Update(MaterialBase[][] map);
}
