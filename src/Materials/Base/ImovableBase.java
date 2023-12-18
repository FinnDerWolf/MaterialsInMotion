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

        @Override
        public boolean canSwap(MaterialBase field) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public MaterialBase[][] swap(MaterialBase[][] map, MaterialBase field) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public MaterialBase[] getFieldsOfInterest(MaterialBase[][] map) {
            // TODO Auto-generated method stub
            return null;
        }
}