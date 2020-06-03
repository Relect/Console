import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String json = in.nextLine();
            if (!json.startsWith("{") || !json.endsWith("}") || (json.indexOf(':') == -1)) throw new InputMismatchException();

            
        } catch (InputMismatchException e) {
            System.out.println("JSON должен начинаться с \"{\",  заканчиваться \"}\" и иметь \":\". ");
        }

    }
}
