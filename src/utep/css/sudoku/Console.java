/***************************************************************
 * Created by: Jose Nieto
 * CS 3331 Advanced Object-Oriented Programming, Spring 2018
 * Last Modification: 29/01/2018
 ***************************************************************/

package utep.css.sudoku;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Console
{
    private int size;
    private PrintStream out;
    private Board board;
    public Scanner input = new Scanner(System.in);

    public Console(){
        out = new PrintStream(System.out);
        //in  = new InputStream(System.in);
    }

    public void welcomeMessage() {
        out.println("Welcome Message");
    }

    /**************************
     *                        *
     *      Out-Methods       *
     *                        *
     *************************/

    public int askSize() {
        out.println("Please set a size option for your board: ");
        out.println("1) 9 x 9");
        out.println("2) 4 x 4");
        out.println("(If you type none of those the default is 9 x 9)");

        this.size = input.nextInt();

        switch (size) {
            case 1:
                this.size = 3;
                return this.size;
            case 2:
                this.size = 2;
                return this.size;
            default:
                this.size = 3;
                return this.size;
        }

    }

    public void showBoard(int[][] arr) {
        out.println("");
        for(int col = 0; col < arr.length; col++) {
            System.out.print(col);
            for(int row = 0; row < arr[col].length; row++) {
                if (row % this.size == 0) {
                    System.out.print("   ");
                    System.out.print("|      ");;
                }
                if (arr[row][col] == 0) System.out.print("X ");
                else System.out.print(arr[row][col] + " ");
                if (row == arr.length - 1 && (col+1) % this.size == 0 && col != 0) System.out.print("    \n  ");
            }
            System.out.print("\n");
        }
        out.println("");
    }

    public void showMessage(Object x) {
        System.out.println(x);
    }

    /**************************
     *                        *
     *      In-Methods        *
     *                        *
     *************************/

    public int userInput() {
        return input.nextInt();
    }

}
