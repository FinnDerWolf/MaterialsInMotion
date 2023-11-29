package Materials.Base;

public abstract class LiquidBase extends MaterialBase{
    
    public LiquidBase(int xCord, int yCord){
        super(xCord, yCord);

        this.state = AggregateStates.gaseous;
    }

    public MaterialBase[][] Update(MaterialBase[][] map){
        return map;
    }

}
