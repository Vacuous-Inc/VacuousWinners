package VacuousWinners;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JPanel;

import VacuousWinners.ImageHandler.ImageName;

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