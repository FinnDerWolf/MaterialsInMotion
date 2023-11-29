package Materials.Base;
import java.util.SplittableRandom;

public abstract class SolidBase extends MaterialBase{
    
    public SolidBase(int xCord, int yCord){
        super(xCord, yCord);

        this.state = AggregateStates.solid;

    }

    public MaterialBase[][] Update(MaterialBase[][] map){
        MaterialBase down = map[yCord-1][xCord];
        MaterialBase downLeft = map[yCord-1][xCord-1];
        MaterialBase downRight = map[yCord-1][xCord+1];
        
        if(canSwap(down)){
            map[yCord][xCord] = down;
            map[yCord-1][xCord] = this;
            return map;
        }

        SplittableRandom random = new SplittableRandom();
        int randomNumber = random.nextInt();

        if (randomNumber % 2 == 0) {
            if (canSwap(downRight)) {
                map[yCord][xCord] = downRight;
                map[yCord-1][xCord+1] = this;
                return map;
            }
        }

        else if(canSwap(downLeft)){
            map[yCord][xCord] = downLeft;
            map[yCord-1][xCord-1] = this;
            return map;
        }
        
        return map;
    }

    private boolean canSwap(MaterialBase field){
        //is Gas
       if(field.state == AggregateStates.gaseous){
            return true;
        }  
        //is less dense Liquid
        else if (field.state == AggregateStates.liquid && this.density > field.density) {
            return true;
        }

        return false;
    }
}
