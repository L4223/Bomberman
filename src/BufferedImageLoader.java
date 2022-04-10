//Noch nicht genutzt und bisher nur von einem Tutorial abgeschrieben


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class BufferedImageLoader {

    public BufferedImage loadImage(String pathRelativeToThis) throws IOException {
        URL url = this.getClass().getResource(pathRelativeToThis);
        BufferedImage image = ImageIO.read(url);
        return image;
    }
}
