package VacuousWinners;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHandler {
    public static enum ImageName {
        TITLE, START, SETTINGS, BACKGROUND, PLAYER, MONSTER, SHOP_EMPTY, UPGRADE;
    }

    public static BufferedImage getImage(ImageName name) throws IOException {
        switch (name) {
            case TITLE: return ImageIO.read(new File("GameName/images/title.jpg"));
            case START: return ImageIO.read(new File("GameName/images/start.png"));
            case SETTINGS: return ImageIO.read(new File("GameName/images/settings.png"));
            case BACKGROUND: return ImageIO.read(new File("GameName/images/background.jpg"));
            case PLAYER: return ImageIO.read(new File("GameName/images/Player_Neutral.png"));
            case MONSTER: return ImageIO.read(new File("GameName/images/Minotaur.png"));
            case SHOP_EMPTY: return ImageIO.read(new File("GameName/images/shopempty.png"));
            case UPGRADE: return ImageIO.read(new File("GameName/images/upgrade.png"));
        }
        return null;
    }
}
