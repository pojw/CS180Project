import java.util.ArrayList;

public class gameController {
    GameBoard board;
    Player player;
    ArrayList<Monster> monsters;

    public gameController(){
        board = new GameBoard();
        player = new Player(0,0);
        monsters = new ArrayList<>();
    }

    public void startEasy(){
        int[] playerStarting = new int[2];
        playerStarting[0] = 0;
        playerStarting[1] = 0;
        board.addPlayer( playerStarting);

        int[][] waterStarting  = new int[3][2];
        waterStarting[0][0] = 1;
        waterStarting[0][1] = 1;

        waterStarting[1][0] = 5;
        waterStarting[1][1] = 5;

        waterStarting[2][0] = 6;
        waterStarting[2][1] = 1;

        board.addWater(waterStarting[0]);
        board.addWater(waterStarting[1]);
        board.addWater(waterStarting[2]);

        int[] monsterStarting = new int[2];
        monsterStarting[0] = 2;
        monsterStarting[1]  = 2;

        Monster m1 = new Monster(2, 2);
        monsters.add(m1);
        board.addMonster( monsterStarting);
    }

    public void handlePlayerMove(String direction) {
        int[] desiredCoords = player.getFutureCord(direction);
        int targetX = desiredCoords[0];
        int targetY = desiredCoords[1];

        if (targetX >= 0 && targetX < 8 && targetY >= 0 && targetY < 8) {

            if (board.board[targetX][targetY] != 3) {

                board.board[player.getX()][player.getY()] = 0;

                player.setPosition(targetX, targetY);

                board.board[targetX][targetY] = 1;

                for (Monster m : monsters) {
                    int[] mCoords = m.getFutureCord();
                    int mX = mCoords[0];
                    int mY = mCoords[1];

                    if (mX < 0 || mX >= 8 || mY < 0 || mY >= 8 || board.board[mX][mY] == 3) {
                        m.reverseDirection();
                    } else {
                        board.board[m.getX()][m.getY()] = 0;
                        m.setPosition(mX, mY);
                        board.board[mX][mY] = 2;
                    }
                }            }
        }
    }
}