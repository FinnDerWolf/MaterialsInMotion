package Logik;

public class MaterialBrush {
    public int size;
    public Materials Material;

    enum Materials {
        Sand,
        Air,
        Water,
        Stone
    }

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

    public void increaseSize(){
        size++;
    }

    public void decreaseSize(){
        size--;
    }
}
