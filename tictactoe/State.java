package tictactoe;

/**
 * Tic-Tac-Toe state variables.
 */
public class State
{
    private int gameState = Constants.STANDBY;
    private int whoseMove = Constants.X;
    private String xName = "";
    private String oName = "";
    private int[][] board = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE + 1];
    private int[] rowCheck = new int[Constants.BOARD_SIZE + 1];
    private int[]colCheck = new int[Constants.BOARD_SIZE];
    private int[] slopeCheck = new int[Constants.BOARD_SIZE];
    private int[] invSlopeCheck = new int[Constants.BOARD_SIZE];
    public int rowSaver = 0;
    public int colSaver = 0;
    public boolean isWinner() {
        int slopeSize = 0;// create two variables representing the row and col 
        //saver, which go down nutil one reaches 0. then, add one to each until
        // the row one is equal to six or the col one is equal to seven

        for (int row=0; row<Constants.BOARD_SIZE; row++) {
            colCheck[row] = getBoardCell(row, colSaver);
        }
        for (int col=0; col<Constants.BOARD_SIZE + 1; col++) {
            rowCheck[col] = getBoardCell(rowSaver,col);
        } 
        slopeCheck = setSlopeCheck(slopeCheck, 1);
        invSlopeCheck = setSlopeCheck(invSlopeCheck, -1);
        if(arrayCheck(rowCheck) == true || arrayCheck(colCheck) == true || arrayCheck(slopeCheck) == true || arrayCheck(invSlopeCheck) == true){
            return true;
        }
        return false;
    }
    public int[] setSlopeCheck(int[] slopeCheck, int posOrNeg ){
        int col= colSaver;
        int row = rowSaver;
        int forLooper = 0;
        if(posOrNeg == -1){
             while(col > 0 && row > 0){
                col = col - 1;
                row = row -1;
            }
            while(col < Constants.BOARD_SIZE && row < Constants.BOARD_SIZE - 1){
                slopeCheck[forLooper] = getBoardCell(row, col);
                col =  col + 1;
                row = row + 1;
                forLooper = forLooper + 1;
            }
        }else{
            while(col > 0 && row < Constants.BOARD_SIZE - 1){
                col = col - 1;
                row = row + 1;
            }
            while(col < Constants.BOARD_SIZE && row > 0){
                slopeCheck[forLooper] = getBoardCell(row, col);
                col =  col + 1;
                row = row + 1;
                forLooper = forLooper + 1;
            }
        }
        return slopeCheck;
    }
    public boolean arrayCheck(int[] numb){
        for(int i = 0; i < numb.length - 3; i ++){
            try{
                if(numb[i] + numb[i + 1] + numb[i + 2] + numb[i + 3]  == (4 * this.getWhoseMove())){
                    return true;   
                } 
            }catch(Exception e) {

            }
        }
        return false;
    }

    public boolean isTie() {
        for (int row=0; row<Constants.BOARD_SIZE; row++) {
            for (int col=0; col<Constants.BOARD_SIZE; col++) {
                if (getBoardCell(row,col) == Constants.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getWhoseMove() {
        return whoseMove;
    }

    public void setWhoseMove(int whoseMove) {
        this.whoseMove = whoseMove;
    }

    public String getXName() {
        return xName;
    }

    public void setXName(String xName) {
        this.xName = xName;
    }

    public String getOName() {
        return oName;
    }

    public void setOName(String oName) {
        this.oName = oName;
    }

    public int getBoardCell(int row, int col) {
        return this.board[row][col];
    }

    public void setBoardCell(int row, int col, int value) {
        this.board[row-1][col-1] = value;
    }
}

