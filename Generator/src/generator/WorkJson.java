package generator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        
        try {
            JSONObject object = (JSONObject) parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME), "UTF8")));      
            
           // BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME), "UTF8"));

            
            
            operation = (String) object.get(attribute[0]);
            
            if (operation==null){
                operation = "Операция не найдена. Повторите попытку.";
                return operation;
            }
            
            if(attribute.length == 1){
                return operation;
            }
          
            for (int i = 1; i < attribute.length; i++) {
                functionATT1 = (String) object.get(brackets(attribute[i]));
                
            if(functionATT1 == null){
                operation = operation.replaceFirst("\\?",brackets(attribute[i]));               
            }
            else {
                operation = operation.replaceFirst("\\?",functionATT1);
                }   
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

