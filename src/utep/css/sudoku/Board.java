package utep.css.sudoku;

import java.util.Random;
import java.math.*;

public class Board {

    private int size;
    private int[][] board;

    public Board(int size) {
        this.size = size;
        this.generate();
    }

    public boolean isSolved() {
        return sumNumbers();
    }

    private void generate() {
        this.board = new int[(int)Math.pow(size,2)][(int)Math.pow(size,2)];

        for (int col = 0; col < this.board.length ; col++) {
            for (int row = 0; row < this.board.length ; row++) {
                this.board[col][row] = 0;
            }
        }
    }

    public void showBoard() {
        for(int col = 0; col < this.board.length; col++) {
            for(int row = 0; row < this.board[col].length; row++) {
                if (row % 3 == 0) {
                    System.out.print("   ");
                    System.out.print("|      ");;
                }
                if (this.board[row][col] == 0) System.out.print("X ");
                else System.out.print(this.board[row][col] + " ");
                if (row == this.board.length - 1 && (col+1) % 3 == 0 && col != 0) System.out.print("    \n  ");
            }
            System.out.print("\n");
        }
    }

    /***************************
     *                         *
     *      Solving methods    *
     *                         *
     **************************/

    private boolean sumNumbers() {
        int rowSum = 0;

        for (int col = 0; col < this.board.length ; col++) {
            for (int row = 0; row < this.board[col].length ; row++)
                rowSum += this.board[col][row];
        }

        return (rowSum == solvingNumber());

    }

    private int solvingNumber() {
        int sum = 0;

        for (int i = 0; i < this.board.length ; i++) {
            sum += i;
        }

        return sum * this.board.length;

    }

    /*******************************
     *                             *
     *      Fill Methods           *
     *                             *
     ******************************/

    public boolean fill(int n, int col, int row) {

        if(this.isValid(n, col, row))
            this.board[col][row] = n;
        else
            return false;

        return true;
    }

    /*******************************
     *                             *
     *      Verification Methods   *
     *                             *
     ******************************/

    private boolean isValid(int n, int col, int row) {

        if(this.isInsideColumn(n, row) || this.isInsideRow(n, col))
            return false;
        else
            return true;

    }

    private boolean isInsideRow(int n, int col) {
        for (int i = 0; i < this.board.length ; i++) {
            if(this.board[col][i] == n)
                return true;
        }
        return false;
    }

    private boolean isInsideColumn(int n, int row) {
        for(int i = 0; i < this.board.length ; i++) {
            if(this.board[i][row] == n)
                return true;
        }
        return false;
    }

}
