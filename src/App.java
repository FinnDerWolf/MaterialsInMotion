import javax.swing.SwingUtilities;

import Logik.Game;
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Game game1 = new Game(true);
                //game1.run();

                Game game2 = new Game(true);
                game2.run();
            }
        });
    }
}

