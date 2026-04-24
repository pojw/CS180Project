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

    // Basic tracker for animation loop
    private int animationStep = 0;
    // x y coordinate
    private double x;
    private double y;
    // Value to scale by
    private int scale = 0;
    // Image to be rendered
    private BufferedImage image;

    /*
     * PixelSprite constructor - takes an image filename, reads the image file and stores it.
     * Sets starting x and y values
     */
    public PixelSprite(String filename, int x, int y) {
        this.x = x;
        this.y = y;
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Overrides interface draw method
     * Updates x and y, calculates scale, and performs animation
     * You can set up scale such that all images are the same size if desired
     * You can also use multiple images to create animation loops!
     * You should try out multiple approaches
     */
    @Override
    public void draw(Graphics2D g, double xx, double yy, int frameW, int frameH) {
        //update x and y
        this.x = xx;
        this.y = yy;

        // Calculate scale factor -> constant can be any value that works for your design
        this.scale = frameW / 300;

        // Resets animation loop -> you could also have it switch directions! Try out ideas and see what works.
        if (this.animationStep > (3 * this.scale)) {
            this.animationStep = 0;
        }

        // Convert to int for draw image and apply animation on the y axis
        int px = (int) x;
        int py = (int) y - animationStep * scale;

        // Draw the image at the x/y location. The image size is defined by width and height
        g.drawImage(image, px, py, this.image.getWidth(), this.image.getHeight(), null);

        // Increment the animation loop
        this.animationStep += Math.max(1 * this.scale / 2, 1);
    }

    // Method to get x value for draw
    @Override
    public double getX() {
        return this.x;
    }

    // Method to get y value for draw
    @Override
    public double getY() {
        return this.y;
    }
}
