package tictactoe;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Write a description of class UI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UI
{
    Scanner scanner;

    public UI() {
        scanner = new Scanner(System.in);      
    }
    // Utility methods
    public String getXOrO(int whoseMove) {
        return (whoseMove == -1) ? "X" : (whoseMove == 1) ? "O": " ";
    }

    public String getPlayerName(int whoseMove, String xName, String oName) {
        return (whoseMove == -1) ? xName : oName;
    }

    public boolean isLegalMove(State state, int row, int col) {
        return 1 <= (row) && (row) <= Constants.BOARD_SIZE && //setBoardCell in state subtracts 1 from row and column for index
        1 <= (col) && (col) <= Constants.BOARD_SIZE &&          // + 1 at the end adds the 1 back
        state.getBoardCell(row - 1,col - 1) == Constants.BLANK;
    }

    // Prompt for input methods
    public String promptForName(String player) {
        System.out.printf(Constants.GET_PLAYER_NAME, player);
        return scanner.next();
    }

    public int getMoveRow(int col, int[] rowStatus) {
        rowStatus[col - 1] = rowStatus[col - 1] - 1;
        int row = rowStatus[col - 1];
        return row;
    }

    public int getMoveCol(int whoseMove, String xName, String oName) {
        int col = 0;
        int checkCol = 1;
        try {
            while (col <= 0 || col > Constants.BOARD_SIZE) {
                System.out.printf(Constants.GET_COL_MOVE, getXOrO(whoseMove), getPlayerName(whoseMove, xName, oName));
                checkCol = scanner.nextInt();
                if (checkCol < 1 || checkCol > 3) {
                    System.out.println(Constants.INVALID_ROW_OR_COLUMN);
                }
                col = checkCol;
            }
            return col;
        }catch(InputMismatchException I){
            System.out.println(Constants.INVALID_ROW_OR_COLUMN);
            scanner.next();
        }
        return col;
    }

    public boolean startNewGame() {
        System.out.println(Constants.START_NEW_GAME);
        String yesOrNo = scanner.next();
        return yesOrNo.equals("Y") || yesOrNo.equals("y");
    }
    // Printing text methods
    public void printWelcome() {
        System.out.println(Constants.TITLE);
    }

    public void printBoard(State state) {
        System.out.println(Constants.DIVIDER_STRING);
        for (int row = 0; row < Constants.BOARD_SIZE; row++) {
            System.out.printf(Constants.BOARD_STRING, getXOrO(state.getBoardCell(row, 0)), getXOrO(state.getBoardCell(row, 1)),
            getXOrO(state.getBoardCell(row, 2)), getXOrO(state.getBoardCell(row, 3)), 
            getXOrO(state.getBoardCell(row, 4)), getXOrO(state.getBoardCell(row, 5)),
            getXOrO(state.getBoardCell(row, 6)));
            System.out.println();
        }
        System.out.println(Constants.DIVIDER_STRING);
    }

    public void printInvalidRowOrColumn() {
        System.out.printf(Constants.INVALID_ROW_OR_COLUMN);
    }

    public void printInvalidMove(int row, int col) {
        System.out.printf(Constants.INVALID_MOVE_ERROR, row, col);
    }

    public void printMove(State state, int row, int col) {
        System.out.printf(Constants.PRINT_MOVE, getXOrO(state.getWhoseMove()), getPlayerName(state.getWhoseMove(), state.getXName(), state.getOName()), row, col);
        System.out.println();
    } 

    public void printWinner(State state) {
        System.out.printf(Constants.WINNER,
            getXOrO(state.getWhoseMove()),
            getPlayerName(state.getWhoseMove(), state.getXName(), state.getOName())
        );
        System.out.println();
    }

    public void printTieGame() {
        System.out.println(Constants.TIE_GAME);
    }
}

