public class GameBoard {
    int[][] board;

    public GameBoard(){
        board = new int[8][8];
        // 0 for empty
        for(int i = 0;i<8;i++){
            for(int j =0; j<8;j++){
                board[i][j] = 0;
            }
        }
    }
    public String addPlayer(int[] cordinates){
        if(cordinates[0]>=8||cordinates[0]<0||cordinates[1]>=8||cordinates[1]<0){
            return "out";
        }else if (board[cordinates[0]][cordinates[1]] !=0) {
            return "full";
        }
        else{
            //1 for player
            board[cordinates[0]][cordinates[1]] = 1;
            return "placed";
        }
    }
    public String addMonster( int[] cordinates){
        if(cordinates[0]>=8||cordinates[0]<0||cordinates[1]>=8||cordinates[1]<0){
            return "out";
        }else if (board[cordinates[0]][cordinates[1]] !=0) {
            return "full";
        }
        else{
            //2 for monster
            board[cordinates[0]][cordinates[1]] = 2;
            return "placed";
        }
    }
    public String addWater(int[]cordinates){
        if(cordinates[0]>=8||cordinates[0]<0||cordinates[1]>=8||cordinates[1]<0){
            return "out";
        }else if (board[cordinates[0]][cordinates[1]] !=0) {
            return "full";
        }
        else{
            //3 for water
            board[cordinates[0]][cordinates[1]] = 3;
            return "placed";
        }
    }
    public String addStart(int[]cordinates){
        if(cordinates[0]>=8||cordinates[0]<0||cordinates[1]>=8||cordinates[1]<0){
            return "out";
        }else if (board[cordinates[0]][cordinates[1]] !=0) {
            return "full";
        }
        else{
            //4 for start
            board[cordinates[0]][cordinates[1]] = 4;
            return "placed";
        }
    }
    public String addEnd(int[]cordinates){
        if(cordinates[0]>=8||cordinates[0]<0||cordinates[1]>=8||cordinates[1]<0){
            return "out";
        }else if (board[cordinates[0]][cordinates[1]] !=0) {
            return "full";
        }
        else{
            //5 for end
            board[cordinates[0]][cordinates[1]] = 5;
            return "placed";
        }
    }
    public String isValid(int[] cordinates){
        if(board[cordinates[0]][cordinates[1]]==0){
            return "grass";
        }else{
            if(board[cordinates[0]][cordinates[1]]==2){
                return"monster";
            }else{
                return"water";
            }
        }
    }

    }



