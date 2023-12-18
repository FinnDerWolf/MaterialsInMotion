package Logik;

import Materials.Base.MaterialBase;

public interface IMaterialUpdate {

    default public MaterialBase getField(MaterialBase[][] map, int xCord, int yCord){
        if(xCord < 0 || xCord >= map[0].length || yCord < 0 || yCord >= map.length){
            return null;
        }
        return map[yCord][xCord];
    }

    public boolean canSwap(MaterialBase field);

    public MaterialBase[][] swap(MaterialBase[][] map, MaterialBase field);

    public MaterialBase[] getFieldsOfInterest(MaterialBase[][] map);
}
