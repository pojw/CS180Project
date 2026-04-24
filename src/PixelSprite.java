import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * PixelSprite class
 * An example sprite class that reads from a PNG file and has a default animation
 *
 * @author Purdue CS
 * @version April 10, 2026
 */

class PixelSprite implements Sprite {

    private int animationStep = 0;
    private double x;
    private double y;
    private int scale = 0;
    private BufferedImage image;

    public PixelSprite(String filename, int x, int y) {
        this.x = x;
        this.y = y;
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void draw(Graphics2D g, double xx, double yy, int frameW, int frameH) {
        this.x = xx;
        this.y = yy;

        this.scale = frameW / 300;

        if (this.animationStep > (3 * this.scale)) {
            this.animationStep = 0;
        }

        int px = (int) x;
        int py = (int) y - animationStep * scale;

        g.drawImage(image, px, py, this.image.getWidth(), this.image.getHeight(), null);

        this.animationStep += Math.max(1 * this.scale / 2, 1);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
