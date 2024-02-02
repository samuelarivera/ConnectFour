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
    public int rowSaver = 0;
    public int colSaver = 0;
    public boolean isWinner() {
        int slopeSize = 0;// create two variables representing the row and col 
        //saver, which go down nutil one reaches 0. then, add one to each until
        // the row one is ewual to sic or the col one is equal to seven
        
        for (int row=0; row<Constants.BOARD_SIZE; row++) {
            colCheck[row] = getBoardCell(row, colSaver);
        }
        for (int col=0; col<Constants.BOARD_SIZE + 1; col++) {
            rowCheck[col] = getBoardCell(rowSaver,col);
        } 
        for(int indexCol = 0; indexCol < Constants.BOARD_SIZE - 4; indexCol++){
            if(colCheck[indexCol] + colCheck[indexCol + 1] + colCheck[indexCol + 2] + colCheck[indexCol + 3]  == (4*this.getWhoseMove())){
             return true;   
            }
        }
        for(int indexRow = 0; indexRow < Constants.BOARD_SIZE - 3; indexRow++){
            if(rowCheck[indexRow] + rowCheck[indexRow + 1] + rowCheck[indexRow + 2] + rowCheck[indexRow + 3]  == (4*this.getWhoseMove())){
             return true;   
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


