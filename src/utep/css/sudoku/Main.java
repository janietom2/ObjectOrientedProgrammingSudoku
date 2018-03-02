/***************************************************************
 * Created by: Jose Nieto
 * CS 3331 Advanced Object-Oriented Programming, Spring 2018
 * Last Modification: 29/01/2018
 ***************************************************************/


package utep.css.sudoku;

import utep.css.sudoku.Console;

public class Main {

    private static Console consoleUI = new Console();
    private static Board board;

    public static void main(String[] args) {
        play();
    }

    private static void play() {

        int inputNumber, selectedColumn, selectedRow;
        consoleUI.welcomeMessage();
        int size = consoleUI.askSize();
        Board board = new Board(size);

        while( !board.isSolved()) {

            consoleUI.showBoard(board.getBoard());

            consoleUI.showMessage("Input a number to fill or -1 reset or -2 to exit");
            inputNumber    = consoleUI.userInput();

            if(inputNumber == -2){
                consoleUI.showMessage("bye bye!");
                return;
            }

            if(inputNumber == -1) {
                board.reset();
                continue;
            }

            consoleUI.showMessage("Column: ");
            selectedColumn = consoleUI.userInput();

            consoleUI.showMessage("Row: ");
            selectedRow    = consoleUI.userInput();

            if(!board.fill(inputNumber, selectedColumn, selectedRow))
                consoleUI.showMessage("==== Invalid input ====");

        }
        consoleUI.showMessage("Congratulations you solved the Sudoku!");
    }


}
