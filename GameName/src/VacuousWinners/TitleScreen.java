package VacuousWinners;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TitleScreen extends Screen {

    final static String BUTTON_LOCATION = "GameName/images/button.jpg";
    
    public TitleScreen(JFrame f) {
        super(f);
    }

    @Override
    public void draw() throws IOException {
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.add(Box.createRigidArea(new Dimension(0,300)));

        JLabel label = new JLabel("Game\nName");
        label.setFont(new Font("Sans serif", Font.PLAIN, 80));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.getContentPane().add(label);

        frame.add(Box.createRigidArea(new Dimension(0,50)));

        BufferedImage buttonIcon = ImageIO.read(new File(BUTTON_LOCATION));
    
        JButton button = new JButton(new ImageIcon(buttonIcon));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBorder(BorderFactory.createEmptyBorder());
        frame.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try { // todo fix this
                    App.startGame(frame);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        frame.repaint();
        frame.revalidate();
    }
}
