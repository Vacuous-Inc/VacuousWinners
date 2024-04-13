package VacuousWinners;

import java.io.IOException;

import javax.swing.JFrame;

public abstract class Screen{
    public JFrame frame;

    public Screen(JFrame f) {
        frame = f;
    }

    public void draw() throws IOException { }
}
