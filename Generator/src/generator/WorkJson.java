
package generator;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class WorkJson {
   
    private static final String FILENAME = "C:\\Users\\usersbt\\Documents\\NetBeansProjects\\xslt-generator\\Generator\\src\\generator\\Json.json";
     
    public static void parseJson(String[] attribute) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject object = (JSONObject) parser.parse(new FileReader(FILENAME));
            
            String operation = (String) object.get(attribute[0]);
            String outStr = null;
            String [] attr = operation.split("?");
            for(String i:attr){
                for(String j:attribute){
                    outStr+
                }
            
            }
            System.out.println(outStr);
            
            
            
        } catch (IOException | ParseException ex) {
            Logger.getLogger(WorkJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

