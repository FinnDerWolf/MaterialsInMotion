package Materials.Base;

public abstract class ImovableBase extends MaterialBase{
    
    public ImovableBase(int xCord, int yCord){
        super(xCord, yCord);

        this.state = AggregateStates.gaseous;
    }

    public MaterialBase[][] Update(MaterialBase[][] map){
        return map;
    }
}
