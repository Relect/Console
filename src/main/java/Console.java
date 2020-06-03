import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String json = in.nextLine();
            if (!json.startsWith("{\"") ||
                    !json.endsWith("\"}") ||
                    (json.indexOf(':') == -1)) throw new InputMismatchException();

            String json1 = json.substring(1);
            String [] key = new String[10];
            String [] value = new String[10];
            int i = 0;

            while (!json1.startsWith("}")){
                key[i] = json1.substring(1,json1.indexOf(':')-1);

                if (json1.indexOf(',') != -1) {
                    value[i] = json1.substring(json1.indexOf(':') + 2, json1.indexOf(',') - 1);
                    json1 = json1.substring(json1.indexOf(',') + 1);
                } else {
                    value[i] = json1.substring(json1.indexOf(':') + 2, json1.indexOf('}') - 1);
                    json1 = json1.substring(json1.indexOf('}'));
                }
                i++;
            }
            System.out.println(json1);
            for (i = 0; i < key.length; i++) {
                if (key[i] != null) {
                    System.out.print(key[i]+":");
                    System.out.println(value[i]);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("JSON должен начинаться с \"{\",  заканчиваться \"}\" и иметь \":\". ");
        }

    }
}
