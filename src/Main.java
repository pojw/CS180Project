import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

    public static void main(String[] args) {
        // Run the GUI safely on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> createGUI());
    }

    private static void createGUI() {
        gameController controller = new gameController();
        controller.startEasy();

        // 2. Initialize JFrame
        JFrame frame = new JFrame("8x8 Grid Game");

        GamePanel panel = new GamePanel(controller.board);

        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
                    controller.handlePlayerMove("w");
                }
                else if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
                    controller.handlePlayerMove("s");
                }
                else if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                    controller.handlePlayerMove("a");
                }
                else if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                    controller.handlePlayerMove("d");
                }

                panel.repaint();
            }

            public void keyTyped(KeyEvent e) {}

            public void keyReleased(KeyEvent e) {}
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);

        panel.requestFocusInWindow();
    }
}