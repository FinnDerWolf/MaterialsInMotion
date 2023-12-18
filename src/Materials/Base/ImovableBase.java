package Materials.Base;

import Logik.IMaterialUpdate;

public abstract class ImovableBase extends MaterialBase implements IMaterialUpdate{
    
    public ImovableBase(int xCord, int yCord){
        super(xCord, yCord);

        this.state = AggregateStates.gaseous;
    }

        //Interface implementation
        @Override
        public MaterialBase[][] Update(MaterialBase[][] map){
            this.isHandled = true;
            return map;
        }
}