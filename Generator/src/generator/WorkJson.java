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
    public static String space = "";
    public static ArrayList <String> spaceX = new ArrayList();
    public static int i = -1;
    public static JSONObject object = new JSONObject();
    
    public static String parseJson(String[] attribute){
        JSONParser parser = new JSONParser();
        String operation = null;
        String functionATT1 = null;
        String resultALL = null;
        
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
                operation = operation.replace("?","");
                return operation;
            }
            for (int i = 1; i < attribute.length; i++) {
                attribute[i] = attribute[i].replace("\n","");
                char[] functionsimv = attribute[i].toCharArray();
                    
                if(functionsimv[1]=='<'){
                    resultALL = outLineTeg(brackets(attribute[i]));    
                    operation = operation.replaceFirst("\\?", resultALL);
                }
                else { 
                    functionATT1 = (String) object.get(brackets(attribute[i]));   

                    if(functionATT1 == null){
                        operation = operation.replaceFirst("\\?", brackets(attribute[i]));               
                    }
                    else {
                        operation = operation.replaceFirst("\\?", functionATT1);
                    }   
                }
            }  
        operation = outLine(operation);
        return operation;
    }
    
    public static String outLine(String text){
                while (text.contains("“”")){
            String rem = "";
            int t = text.indexOf("“”");          
            char[] oper = text.toCharArray();
            
            while(oper[t] != ' '){
                t--;
            }  
            t++;
            
            while(oper[t] != ' '){
                rem += oper[t];
                t++;
            }
            text = text.replace(rem,"");
        }
        return text;
    }
    
    public static String brackets(String bracket){
        String param = bracket.replace("(","");
        param = param.replace(")","");
        param = param.replace(";","");
        param = param.replace("\t","");
        
        while(param.contains("   ")) {
            String replace = param.replace("   ", "");
            param=replace;
        }
        while(param.contains("  ")) {
            String replace = param.replace("  ", "");
            param=replace;
        }
        return param;
    }
    
    public static String outLineTeg(String text){ 
        i++;
        
        if(spaceX.size()>i){
            spaceX.set(i, space);
        }else{
            spaceX.add(space);
        }
        
        space += "    ";
        String result = "";
        String[] resultLin = new String[5];
        String resultLine = null;
        
        resultLine = readTeg(text);

        if (resultLine.equals(text)){
            String functionATT = (String) object.get(brackets(resultLine));
            if (functionATT!=null){
                result = "\n" + space + functionATT;
                return result;
            } else resultLin[1] = resultLine;
        }
        else{ 
            resultLin = text.split(resultLine);
        }
        
        String tempTwoLine =  resultLine.substring(1,resultLine.length());
        tempTwoLine = "</" + tempTwoLine;
        String[] tempLines = resultLin[1].split(tempTwoLine);

        if (!tempLines[0].equals(resultLin[1])){
            result = "\n" + space + resultLine + space + space + outLine(tempLines[0]) + "\n" + spaceX.get(i) + tempTwoLine;
            i--;
        }
        else{
            result = "\n" + space + resultLine;
        }
                
        if(tempLines.length>1){
            space = "";
            result += outLine(tempLines[1]);
        }
        space = "";
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
