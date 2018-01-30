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
        //this.board = new int[(int)Math.pow(size,2)][(int)Math.pow(size,2)]; // Debug test
        this.board = new int[this.size*3][this.size*3];

        int colCounter = 0;
        int rowCounter = 0;

        // This can be more efficient. (To do) ( O(n^2) )
        for (int i = 0; i < this.size ; i++) {
            for (int j = 0; j < this.size ; j++) {
                colCounter = 0;
                rowCounter = 0;
            }
                for (int col = 0; col < 3 ; col++) {
                    for (int row = 0; row < 3 ; row++) {
                        this.board[colCounter][rowCounter] = 0;
                        rowCounter++;
                    }
                    colCounter++;
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

    /**
     *
     *  This method will calculate the sum of all numbers on the current sudoku board.
     *  It will check and return a boolean. Positive if the sum of the current sudoky is equals to a solved sudoku
     *
     * @return
     */

    private boolean sumNumbers() {
        int rowSum = 0;

        for (int col = 0; col < this.board.length ; col++) {
            for (int row = 0; row < this.board[col].length ; row++)
                rowSum += this.board[col][row];
        }

        return (rowSum == solvingNumber());

    }

    /**
     *  This method will solve the sum of all the sudoku numbers, meaning that if the users fills all sudoku
     *  the sum of all numbers should be the same as the return of this method
     * @return
     */
    private int solvingNumber() {
        int sum = 0;

        for (int i = 1; i <= this.board.length ; i++) {
            sum += i;
        }

        return sum * this.board.length;

    }

    /*******************************
     *                             *
     *      Fill Methods           *
     *                             *
     ******************************/


    /**
     *
     * @param n: Stands for the number input by the user (Which needs to be validated)
     * @param col: Stands for the column where the user whishes to input n
     * @param row: Stands for the row where the user wishes to input n
     *
     * This method checks first if the input is valid, that means if it follows the rules
     * of the board game. This is check by the method (isValid) if it is then will include
     * the number on the desired row and column
     *
     * @return
     */
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
