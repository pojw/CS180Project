import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private GameBoard gameBoard;

    public GamePanel(GameBoard board) {
        this.gameBoard = board;
        setFocusable(true);
        setBackground(Color.DARK_GRAY); // Background behind the grid

        new Timer(64, e -> {
            repaint();
        }).start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (gameBoard == null || gameBoard.board == null) {
            return;
        }

        int tileWidth = getWidth() / 8;
        int tileHeight = getHeight() / 8;

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {

                int tileValue = gameBoard.board[x][y];

                if (tileValue == 0) {
                    g.setColor(Color.GREEN);        //Grass
                } else if (tileValue == 1) {
                    g.setColor(Color.RED);          // Player
                } else if (tileValue == 2) {
                    g.setColor(Color.ORANGE);       // Monster
                } else if (tileValue == 3) {
                    g.setColor(Color.BLUE);         // Water
                } else if (tileValue == 4) {
                    g.setColor(Color.YELLOW);       // Start
                } else if (tileValue == 5) {
                    g.setColor(Color.MAGENTA);      // End
                }

                g.fillRect(x * tileWidth, y * tileHeight, tileWidth, tileHeight);

                g.setColor(Color.BLACK);
                g.drawRect(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
            }
        }
    }
}