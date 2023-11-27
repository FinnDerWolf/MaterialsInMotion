import Logik.*;
public class App {
    //Const
    final static int Width = 70;
    final static int Height = 50;

    public static void main(String[] args) throws Exception {
        Game game = new Game(Width, Height);
        game.Run();
    }

    
}

