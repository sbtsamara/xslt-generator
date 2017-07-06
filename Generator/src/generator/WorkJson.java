package generator;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WorkJson {
   
    private static final String FILENAME = "C:\\Users\\usersbt\\Documents\\NetBeansProjects\\xslt-generator\\Generator\\src\\generator\\Json.json";
     
    public static String parseJson(String[] attribute) {
        JSONParser parser = new JSONParser();
        String operation = null;
        String function = null;
        String operations = null;
        try {
            JSONObject object = (JSONObject) parser.parse(new FileReader(FILENAME));            
            operation = (String) object.get(attribute[0]); 
            function = (String) object.get(brackets(attribute[1]));
            
            if(function == null){
                for(int i=1; i < attribute.length; i++){
                operation = operation.replaceFirst("\\?",brackets(attribute[i]));               
                }
                  
            }else {
                operation = operation.replaceFirst("\\?",function);
            }
            
        } catch (IOException | ParseException ex) {
            Logger.getLogger(WorkJson.class.getName()).log(Level.SEVERE, null, ex);
        }
         return operation;
    }
    
    private static String brackets(String bracket){
        String param = bracket.substring(1,bracket.length()-1);
        return param;
    }
}

