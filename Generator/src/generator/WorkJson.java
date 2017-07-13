package generator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        String resultALL = null;
        try {
            JSONObject object = (JSONObject) parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME), "UTF8")));      
            operation = (String) object.get(attribute[0]);
            
            if (operation==null){
                operation = "Операция не найдена. Повторите попытку.";
                return operation;
            }
            
            if(attribute.length == 1){
                return operation;
            }
          
            for (int i = 1; i < attribute.length; i++) {
                char[] functionsimv = attribute[i].toCharArray();
                for(char funcsim:functionsimv){
                    if(funcsim=='*'){
                        attribute[i] = attribute[i].substring(2);
                        resultALL = outLine(brackets(attribute[i]));
                        System.out.println(resultALL);    
                        functionATT1 = (String) object.get(resultALL); 
                        break;
                    }
                    else {
                        resultALL = attribute[i]; 
                        break;
                    }
                }

                //functionATT1 = (String) object.get(brackets(attribute[i]));
                
            if(functionATT1 == null){
                operation = operation.replaceFirst("\\?",brackets(resultALL));               
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
        //bracket.substring(1,bracket.length()-1);
        String param = bracket.replace("(","");
        param = param.replace(")","");
        return param;
    }
    
    public static String[] spChar(String bracket){
        String[] funct = bracket.split("*");
        return funct;
    }
    
    public static String outLine(String text){
        String result = "";
        String resultLine = "";
        char[] simv = text.toCharArray();
        for (int i = 0; i < simv.length; i++) {
 //           char sim = simv[i];
            
 //       }
 //           for (char sim:simv){
                if(simv[i] == '<'){

                    while (simv[i] != '>'){
                        resultLine += simv[i]; 
                        
                        i++;
                    }
                }
                else {
                    resultLine += simv[i-1]; 
                    break;
                } 
            }
        result += resultLine+"\n\r";
        System.out.println(result);    
            
//        String[] textRes = text.split("</"+resultLine+">");
//        String textResult = textRes[0].replace(resultLine, "");
        return result;
    }
    
//    public static String outLineTeg(String text){
//        for (char sim:simv){
//    
//        }
//    }
}

