package VacuousWinners;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHandler {
    public static enum ImageName {
        TITLE, START, SETTINGS, BACKGROUND;
    }

    public static BufferedImage getImage(ImageName name) throws IOException {
        switch (name) {
            case TITLE: return ImageIO.read(new File("GameName/images/title.jpg"));
            case START: return ImageIO.read(new File("GameName/images/start.png"));
            case SETTINGS: return ImageIO.read(new File("GameName/images/settings.png"));
            case BACKGROUND: return ImageIO.read(new File("GameName/images/background.jpg"));
        }
        return null;
    }
}
