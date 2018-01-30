package utep.css.sudoku;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Console
{
    private int size;
    private PrintStream out;
    public Scanner input = new Scanner(System.in);

    public Console(){
        out = new PrintStream(System.out);
        //in  = new InputStream(System.in);
    }

    public void welcomeMessage() {
        out.println("Welcome Message");
    }

    public int askSize() {
        out.println("Please set a size for your board: ");
        this.size     = input.nextInt();
        return this.size;
    }

    public void showMessage(Object x) {
        System.out.println(x);
    }

    public int inputNumber() {
        System.out.println("Input a number to fill");

        return input.nextInt();
    }

    public int inputCol() {
        System.out.println("Select which Column");

        return input.nextInt();
    }

    public int inputRow() {
        System.out.println("Select which Row");

        return input.nextInt();
    }

}
