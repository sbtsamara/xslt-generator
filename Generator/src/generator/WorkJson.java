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
    public static String space = "    ";
    public static String[] spaceX = {"","","","","","","","","","","","",""};
    public static int i = -1;

    
    public static String parseJson(String[] attribute){
        JSONParser parser = new JSONParser();
        String operation = null;
        String functionATT1 = null;
        String resultALL = null;
        JSONObject object = new JSONObject();
        
        try {
            object = (JSONObject) parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME), "UTF8")));      
            operation = (String) object.get(attribute[0]);
        }
        catch (IOException | ParseException ex) {
            Logger.getLogger(WorkJson.class.getName()).log(Level.SEVERE, "Неверный путь к файлу Json", ex);    
        }   
            if (operation==null){
                operation = "Операция не найдена. Повторите попытку.";
                return operation;
            }
            
            if(attribute.length == 1){
                return operation;
            }
          
            for (int i = 1; i < attribute.length; i++) {
                char[] functionsimv = attribute[i].toCharArray();

                    if(functionsimv[1]=='<'){
                        resultALL = outLine(brackets(attribute[i]));    
                    }
                    else {
                        resultALL = attribute[i]; 
                        functionATT1 = (String) object.get(brackets(resultALL));
                    }

            if(resultALL != attribute[i]){
                operation = operation.replaceFirst("\\?",resultALL);
                i++;
            }   

            if(functionATT1 == null){
                operation = operation.replaceFirst("\\?",brackets(attribute[i]));               
            }
            else {
                operation = operation.replaceFirst("\\?",functionATT1);
                }   
            }
        return operation;
    }
    
    public static String brackets(String bracket){
        while(bracket.contains("  ")) {
            String replace = bracket.replace("  ", " ");
            bracket=replace;
        }
        
        String param = bracket.replace("(","");
        param = param.replace(")","");
        param = param.replace(";","");
        return param;
    }

    public static String outLine(String text){ 
         i++;
        spaceX[i] = space;
        space += "    ";
       
        String result = "";
        String[] resultLin = new String[5];
        String resultLine = readTeg(text);
        
        if (resultLine.equals(text)){
            resultLin[1] = resultLine;
        }
        else{ 
            resultLin = text.split(resultLine);
        }
        
        String tempTwoLine =  resultLine.substring(1,resultLine.length());
        tempTwoLine = "</" + tempTwoLine;
        String[] tempLines = resultLin[1].split(tempTwoLine);
        
        if (!tempLines[0].equals(resultLin[1])){
            result = "\n" + space + resultLine + space + space + outLine(tempLines[0]) + "\n" + spaceX[i] + tempTwoLine;
            i--;
        }
        else{
            result = "\n" + space + resultLine;
            return result;
        }
        
    return result;
    }
    
    public static String readTeg(String text){
        char[] simv = text.toCharArray();
        String resultLine = "";
   
        for (int i = 0; i < simv.length; i++) {
                if(simv[i] == '<'){
                    while (simv[i] != '>'){
                        resultLine += simv[i]; 
                        i++;
                    }
                    resultLine += simv[i];
                    break;
                }
                else {
                    resultLine += simv[i]; 

                } 
        }
        return resultLine;
    }
}
