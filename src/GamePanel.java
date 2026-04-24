import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * GamePanel class
 * A class that extends JPanel
 * Constructor sets background color, initializes the sprite array, and starts an animation timer
 *
 * @author Purdue CS
 * @version April 10, 2026
 */

class GamePanel extends JPanel {
    // A list that contains the sprites to be animated
    private final ArrayList<Sprite> sprites;

    public GamePanel(Color color) {
        sprites = new ArrayList<>();
        setFocusable(true);
        setBackground(color);

        // Sets a basic time that calls repaint on a set interval
        new Timer(64, e -> {
            repaint();
        }).start();
    }

    // Method to add sprites to the game panel
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    // Method that loops through all sprites and draws them every time repaint is called by the timer
    protected void paintComponent(Graphics g) {
        // This super call is required!
        super.paintComponent(g);
        // Loop through sprites and call draw on each
        for (Sprite s : sprites) {
            s.draw((Graphics2D) g, s.getX(), s.getY(), getWidth(), getHeight());
        }
    }

}

