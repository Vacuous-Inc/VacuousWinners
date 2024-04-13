package VacuousWinners;

import java.io.IOException;
import javax.swing.JFrame;

public class App {

    public static void main(String[] args) throws IOException {  

        //Create and set up the window.
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        TitleScreen title = new TitleScreen(frame);
        title.draw();

        frame.setSize(1920, 1080);

        //Display the window.
        frame.setVisible(true);
    }

    public static void startGame(JFrame frame) throws IOException, InterruptedException {
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.revalidate();

        GameScreen game = new GameScreen(frame);

        game.draw();
    }
}  
