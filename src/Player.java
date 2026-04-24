public class Player {
    private int x;
    private int y;

    public Player(int startX, int startY){
        this.x = startX;
        this.y = startY;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setPosition(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public int[] getFutureCord(String direction) {
        int futureX = this.x;
        int futureY = this.y;

        switch (direction.toLowerCase()) {
            case "w": futureY -= 1; break;
            case "s": futureY += 1; break;
            case "a": futureX -= 1; break;
            case "d": futureX += 1; break;
        }

        return new int[]{futureX, futureY};
    }
}