/***************************************************************
 * Created by: Jose Nieto
 * CS 3331 Advanced Object-Oriented Programming, Spring 2018
 * Last Modification: 29/01/2018
 ***************************************************************/


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

        for (int i = 1; i < this.board.length ; i++) {
            for (int j = 1; j < this.board[i].length ; j++) {
                if(this.board[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public int[][] getBoard() {
        return this.board;
    }

    private void generate() {
        //this.board = new int[(int)Math.pow(size,2)][(int)Math.pow(size,2)]; // Debug test
        this.board = new int[this.size*this.size][this.size*this.size];

        int colCounter = 0;
        int rowCounter = 0;

        // This can be more efficient. (To do) ( O(n^2) )
        for (int i = 0; i < this.size ; i++) {
            for (int j = 0; j < this.size ; j++) {
                colCounter = 0;
                rowCounter = 0;
            }
                for (int col = 0; col < this.size ; col++) {
                    for (int row = 0; row < this.size ; row++) {
                        this.board[colCounter][rowCounter] = 0;
                        rowCounter++;
                    }
                    colCounter++;
                }
        }

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


    /**
     *
     * This methods validates the user input using another methods
     *
     */
    private boolean isValid(int n, int col, int row) {

        if(invalidInput(n, col, row) || isOccupied(col, row) ||this.isInsideColumn(n, row) || this.isInsideRow(n, col) || isInsideSquare(n, col, row))
            return false;
        else
            return true;

    }

    /**
     *
     * This method check if the input is inside a row
     *
     **/
    private boolean isInsideRow(int n, int col) {
        for (int i = 0; i < this.board.length ; i++) {
            if(this.board[col][i] == n)
                return true;
        }
        return false;
    }

    /**
     *
     * This method check if the input is inside a column
     *
     **/
    private boolean isInsideColumn(int n, int row) {
        for(int i = 0; i < this.board.length ; i++) {
            if(this.board[i][row] == n)
                return true;
        }
        return false;
    }
    /**
     *
     * This method check if the input in inside the same square
     *
     **/
    private boolean isInsideSquare(int n, int col, int row) {

        int r = row/this.size;
        int c = col/this.size;

        for (int i = col; i < c+(this.size) ; i++) {
            for (int j = row; j < r+(this.size) ; j++) {
                if(this.board[i][j] == n) {
                    System.out.println("Inside the Square");
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *
     * This method checks if that pointed col and row is already occupied by another number
     *
     */
    private boolean isOccupied(int col, int row) {
        if(this.board[col][row] != 0){
            System.out.println("Is occupied");
            return true;
        }
        return false;
    }

    /**
     *
     *  This methods checks if the method n is valid and that col and row are not out of bounds
     *
     */
    private boolean invalidInput(int n, int col, int row) {

        if(n > this.size*this.size || n <= 0 || col >= this.board.length || row >= this.board.length)
            return true;

        return false;
    }

    /***********************
     *                     *
     *    Extra options    *
     *                     *
     **********************/

    /**
     *
     * This method resets the whole board, every values goes to 0 again
     *
     */
    public void reset() {
        this.generate();
    }

}
