package Logik;

public class MaterialBrush {
    public int size;
    public Materials material;

    enum Materials {
        Sand,
        Air,
        Water,
        Stone,
        Oil
    }

    public MaterialBrush(){
        size = 1;
        material = Materials.Sand;
    }

    public void setMaterial(Materials material){
        this.material = material;
    }

    public void setSize(int size){
        this.size = size;
    }

    public void increaseSize(){
        size++;
    }

    public void decreaseSize(){
        if(size > 0){
            size--; 
        }
    }
}
