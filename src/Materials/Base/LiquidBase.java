package Materials.Base;

import Logik.IMaterialUpdate;

public abstract class LiquidBase extends MaterialBase implements IMaterialUpdate{
    
    public LiquidBase(int xCord, int yCord){
        super(xCord, yCord);

        this.state = AggregateStates.gaseous;
    }

    //Interface implementation
    @Override
    public MaterialBase[][] Update(MaterialBase[][] map) {
        this.isHandled = true;

        var fieldsOfInterest = getFieldsOfInterest(map);

        for (MaterialBase field : fieldsOfInterest) {
            if(canSwap(field)){
                map = swap(map, field);
                return map;
            }
        }

        return map;
    }

    @Override
    public MaterialBase[] getFieldsOfInterest(MaterialBase[][] map){
        var result = new MaterialBase[5];

        //randomize direction priority 
        var randomInt = Math.round(Math.random());

        //down
        result[0] = getField(map, this.xCord, this.yCord+1);

        //Prioritize left
        if(randomInt > 0){
            //down-left and down-right
            result[1] = getField(map, this.xCord-1, this.yCord+1);
            result[2] = getField(map, this.xCord+1, this.yCord+1);

            //left and right
            result[3] = getField(map, this.xCord-1, this.yCord);
            result[4] = getField(map, this.xCord+1, this.yCord);
        }
        //Prioritize right
        else{
            //down-right and down-left
            result[1] = getField(map, this.xCord+1, this.yCord+1);
            result[2] = getField(map, this.xCord-1, this.yCord+1);

            //right and left
            result[3] = getField(map, this.xCord+1, this.yCord);
            result[4] = getField(map, this.xCord-1, this.yCord);
        }
        return result;
    }

    @Override
    public boolean canSwap(MaterialBase field){
        //Liquids try to swap downwards and to the side
        //is null
        if(field == null){
            return false;
        }
        //is less dense Gas
        if(field.state == AggregateStates.gaseous && field.density < this.density){
            return true;
        }  
        //is less dense Liquid
        else if (field.state == AggregateStates.liquid && this.density > field.density) {
            return true;
        }

        return false;
    }

    @Override
    public MaterialBase[][] swap(MaterialBase[][] map, MaterialBase field){
        map[this.yCord][this.xCord] = field;
        map[field.yCord][field.xCord] = this;

        Object tempStore = this.xCord;
        this.xCord = field.xCord;
        field.xCord = (int) tempStore;

        tempStore = this.yCord;
        this.yCord = field.yCord;
        field.yCord = (int) tempStore;
        
        return map;
    }

}
