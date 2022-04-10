//Noch nicht genutzt und bisher nur von einem Tutorial abgeschrieben

import java.awt.image.BufferedImage;



public class SpriteSheet {
    public BufferedImage spriteSheet;
    public SpriteSheet(BufferedImage spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    public BufferedImage grapSprite(int x, int y, int width, int height) {
        BufferedImage spriteSheetSubimage = spriteSheet.getSubimage(x, y, width, height);
        return spriteSheetSubimage;
    }
//    private int frameNumber;
//    private int duration;
//
//    public SpriteSheet(BufferedImage image, int frameNumber, int duration) {
//        this.image = image;
//        this.frameNumber=frameNumber;
//        this.duration = duration;
//    }
}
