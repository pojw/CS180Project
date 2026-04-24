import javax.swing.*;
import java.awt.*;

/**
 * Main class
 * Creates the SwingUtilities invoke later
 * Initializes the GamePanel object and adds sprites
 *
 * @author Purdue CS
 * @version April 10, 2026
 */

public class Main {

    // Main method for the program
    public static void main(String[] args) {
        // Run the GUI

        SwingUtilities.invokeLater(() -> createGUI());
    }

    /*
     * Declares the invokeLater()
     * Sets up the JFrame and GamePanel
     * Adds sprites to the GamePanel
     */
    private static void createGUI() {
        SwingUtilities.invokeLater(() -> {
            // Initialize JFrame
            JFrame frame = new JFrame("Sprite Example");

            // Initialize GamePanel to be a dark green
            GamePanel panel = new GamePanel(Color.decode("#2f7a30"));

            // Add 3 PixelSprites to the GamePanel
            // Courtesy of Veronica Choulga
            panel.addSprite(new PixelSprite("yellow_ducky.png", 200, 200));
            panel.addSprite(new PixelSprite("horse_ducky.png", 400, 400));
            panel.addSprite(new PixelSprite("train_character.png", 400, 100));

            // Set up the frame parameters and make visible
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
