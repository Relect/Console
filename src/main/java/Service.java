import java.util.ArrayList;
import java.util.InputMismatchException;

public class Service {
    // get key
    public static ArrayList<String> key (String json){
        ArrayList<String> result = new ArrayList<String>();
            while (!json.startsWith("}")) {
                if (json.indexOf('\"') != 0 ||
                    json.substring(json.indexOf(':')-1,json.indexOf(':')) != "\"")
                {
                    System.out.println("JSON.key должен начинаться с \" и  заканчиваться \":.");
                    break;
                }
                result.add(json.substring(1, json.indexOf(':') - 1));
                if (json.indexOf(',') != -1) {
                    json = json.substring(json.indexOf(',') + 1);
                } else {
                    json = json.substring(json.indexOf('}'));
                }
            }

        return result;
    }
    // get value
    public static ArrayList<String > value(String json){
        ArrayList<String> res = new ArrayList<String>();
        while (!json.startsWith("}")){
            json = json.substring(json.indexOf(':'));
            if (json.indexOf(',') != -1) {
                res.add(json.substring(json.indexOf(':') + 2, json.indexOf(',') - 1));
                json = json.substring(json.indexOf(',') + 1);
            } else {
                res.add(json.substring(json.indexOf(':') + 2, json.indexOf('}') - 1));
                json = json.substring(json.indexOf('}'));
            }
        }
        return res;
    }

}
