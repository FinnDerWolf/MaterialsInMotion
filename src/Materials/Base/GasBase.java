package Materials.Base;

public abstract class GasBase extends MaterialBase{
    
    public GasBase(int xCord, int yCord){
        super(xCord, yCord);

        this.state = AggregateStates.gaseous;
    }

    public MaterialBase[][] Update(MaterialBase[][] map){
        return map;
    }
}
