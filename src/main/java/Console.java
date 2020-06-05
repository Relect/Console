import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String json = in.nextLine();
            json = json.trim();
            if (!json.startsWith("{\"") ||
                    !json.endsWith("\"}") ||
                    (json.indexOf(':') == -1) ||
                    (json == null)) throw new InputMismatchException();
            String json1 = json.substring(1);

            Service str = new Service();

            System.out.println(str.key(json1));
            System.out.println(str.value(json1));

        } catch (InputMismatchException e) {
            System.out.println("JSON должен начинаться с \"{\",  заканчиваться \"}\" и иметь \":\". ");
        }

    }
}
