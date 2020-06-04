import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    public static ArrayList<String> key (String jsonKey){
        ArrayList<String> result = new ArrayList<String>();
        while (!jsonKey.startsWith("}")){
            result.add(jsonKey.substring(1,jsonKey.indexOf(':')-1));
            if (jsonKey.indexOf(',') != -1) {
                jsonKey = jsonKey.substring(jsonKey.indexOf(',') + 1);
            } else {
                jsonKey = jsonKey.substring(jsonKey.indexOf('}'));
            }
        }
        return result;
    }
    public static ArrayList<String > value(String jsonValue){
        ArrayList<String> result = new ArrayList<String>();
        while (!jsonValue.startsWith("}")){
            jsonValue = jsonValue.substring(1,jsonValue.indexOf(':')-1);
            if (jsonValue.indexOf(',') != -1) {
                result.add(jsonValue.substring(jsonValue.indexOf(':') + 2, jsonValue.indexOf(',') - 1));
                jsonValue = jsonValue.substring(jsonValue.indexOf(',') + 1);
            } else {
                result.add(jsonValue.substring(jsonValue.indexOf(':') + 2, jsonValue.indexOf('}') - 1));
                jsonValue = jsonValue.substring(jsonValue.indexOf('}'));
            }
        }
        return result;
    }
}
