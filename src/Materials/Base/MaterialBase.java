package Materials;

public abstract class MaterialBase {
    String name;
    int xCord;
    int yCord;
    double density;
    boolean isProcessed;

    public void swap(MaterialBase other){
        int xtemp = this.xCord;
        int yTemp = this.yCord;

        this.xCord = other.xCord;
        this.yCord = other.yCord;

        other.xCord = xtemp;
        other.yCord = yTemp;
    }

    abstract void Update();
}
