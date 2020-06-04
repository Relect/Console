import java.util.ArrayList;

public class Service {
    public static ArrayList<String> key (String json){
        ArrayList<String> result = new ArrayList<String>();
        while (!json.startsWith("}")){
            result.add(json.substring(1,json.indexOf(':')-1));
            if (json.indexOf(',') != -1) {
                json = json.substring(json.indexOf(',') + 1);
            } else {
                json = json.substring(json.indexOf('}'));
            }
        }
        return result;
    }
    public static ArrayList<String > value(String json){
        ArrayList<String> result = new ArrayList<String>();
        while (!json.startsWith("}")){
            json = json.substring(json.indexOf(':'));
            if (json.indexOf(',') != -1) {
                result.add(json.substring(json.indexOf(':') + 2, json.indexOf(',') - 1));
                json = json.substring(json.indexOf(',') + 1);
            } else {
                result.add(json.substring(json.indexOf(':') + 2, json.indexOf('}') - 1));
                json = json.substring(json.indexOf('}'));
            }
        }
        return result;
    }
    
}
