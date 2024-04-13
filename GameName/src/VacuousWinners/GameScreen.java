package VacuousWinners;

import java.awt.Canvas;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class GameScreen extends Screen{

    public GameScreen(JFrame f) {
        super(f);
    }

    @Override
    public void draw() throws IOException {
        frame.getContentPane().setLayout(new GridLayout(0, 2));

        Canvas c = new Canvas();
        frame.add(c);
        JSplitPane codeArea = new JSplitPane();
        codeArea.setOrientation(JSplitPane.VERTICAL_SPLIT);
        codeArea.setTopComponent(new Label("You can use any of these methods at any time regardless of the split pane's current split direction. Calls to setLeftComponent and setTopComponent are equivalent and set the specified component in the top or left position, depending on the split pane's current split orientation. Similarly, calls to setRightComponent and setBottomComponent are equivalent. These methods replace whatever component is already in that position with the new one."));
        codeArea.setBottomComponent(new TextArea());

        frame.add(codeArea);

        frame.repaint();
        frame.revalidate();
    }
}
