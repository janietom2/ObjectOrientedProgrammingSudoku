package utep.css.sudoku;

import utep.css.sudoku.Console;

public class Main {

    private static Console consoleUI = new Console();
    private static Board board;

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        consoleUI.welcomeMessage();
        int size = consoleUI.askSize();
        int inputNumber, selectedColumn, selectedRow;
        board = new Board(size);
        board.showBoard();

        while( !board.isSolved() ) {
            inputNumber    = consoleUI.inputNumber();
            selectedColumn = consoleUI.inputCol();
            selectedRow    = consoleUI.inputRow();

            board.fill(inputNumber, selectedColumn, selectedRow);
            board.showBoard();

        }
        consoleUI.showMessage("Congratulations you solved the Sudoku!");
    }


}
