package generator;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WorkJson { 
    
    private static final String FILENAME = "src\\generator\\Json.json"; 

    public static String parseJson(String[] attribute){
        JSONParser parser = new JSONParser();
        String operation = null;
        String functionATT1 = null;
        String functionATT2 = null;
        
        try {
            JSONObject object = (JSONObject) parser.parse(new FileReader(FILENAME));            
            operation = (String) object.get(attribute[0]);
            
            if (operation==null){
                operation = "Операция не найдена. Повторите попытку.";
                return operation;
            }
            
            if(attribute.length == 1){
                return operation;
            }
            functionATT1 = (String) object.get(brackets(attribute[1]));
            functionATT2 = (String) object.get(brackets(attribute[2]));
          
            if(functionATT1 == null){
                operation = operation.replaceFirst("\\?",brackets(attribute[1]));               
            }
            else {
                operation = operation.replaceFirst("\\?",functionATT1);
                }   
            
            if(functionATT2 == null){
                operation = operation.replaceFirst("\\?",brackets(attribute[2]));
            }
            else{
                operation = operation.replaceFirst("\\?",functionATT2);  
            }  
            
        }catch (IOException | ParseException ex) {
            Logger.getLogger(WorkJson.class.getName()).log(Level.SEVERE, "Неверный путь к файлу Json", ex);
        }
        return operation;
    }
    
    public static String brackets(String bracket){
        String param = bracket.substring(1,bracket.length()-1);
        return param;
    }
}

