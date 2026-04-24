public class Monster {
    private int x;
    private int y;
    private String currentDirection;

    public Monster(int startX , int startY){
        this.x = startX;
        this.y= startY;
        this.currentDirection = "w";
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setPosition(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public void reverseDirection() {
        if (currentDirection.equals("w")) {
            currentDirection = "s";
        } else {
            currentDirection = "w";
        }
    }

    public int[] getFutureCord() {
        int futureX = this.x;
        int futureY = this.y;

        if (currentDirection.equals("w")) {
            futureY -= 1;
        } else if (currentDirection.equals("s")) {
            futureY += 1;
        }

        return new int[]{futureX, futureY};
    }
}