package Logik;

import Logik.GameKeyListener.Materials;

public class MaterialBrush {
    public int size;
    public Materials Material;

    public MaterialBrush(){
        size = 1;
        Material = Materials.Sand;
    }

    public void setMaterial(Materials material){
        this.Material = material;
    }

    public void setSize(int size){
        this.size = size;
    }
}
