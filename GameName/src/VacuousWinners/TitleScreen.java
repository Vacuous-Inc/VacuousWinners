package VacuousWinners;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import VacuousWinners.ImageHandler.ImageName;

public class TitleScreen extends Screen {
    
    public TitleScreen(JFrame f) {
        super(f);
    }

    @Override
    public void draw() throws IOException {
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanelWithBackground background = new JPanelWithBackground(ImageName.TITLE);
        frame.add(background);

        JButton button = new JButton(new ImageIcon(ImageHandler.getImage(ImageName.START)));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBorder(BorderFactory.createEmptyBorder());

        background.add(Box.createRigidArea(new Dimension(0,430)));
        background.add(button);

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

    public class JPanelWithBackground extends JPanel {

        private Image backgroundImage;
        public JPanelWithBackground(ImageName name) throws IOException {
          backgroundImage = ImageHandler.getImage(name);
        }
      
        public void paintComponent(Graphics g) {
          super.paintComponent(g);
          g.drawImage(backgroundImage, 0, 0, this);
        }
      }
}
