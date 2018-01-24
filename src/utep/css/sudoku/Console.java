package utep.css.sudoku;
import java.io.InputStream;
import java.io.PrintStream;

public class Console
{
    private InputStream in;
    private PrintStream out;

    public Console(){
        out = new PrintStream(System.out);
        in  = new InputStream(System.in);
    }

    public void welcomeMessage() {
        out.println("Welcome Message");
    }

    public int askSize() {
        // This is a test (Need to ask for the Size)

        return 4;
    }

    public void showMessage(Object x) {

    }

}
