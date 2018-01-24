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
        board = new Board(size);

        while( !board.isSolved() ) {

        }
        consoleUI.showMessage("Congratulations you solved the Sudoku!");
    }


}
