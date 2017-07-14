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
                
                //for (int j = 0; j < functionsimv.length; j++) {
                   // char c = functionsimv[j];
                    
               // }
               // for(char funcsim:functionsimv){
                    if(functionsimv[1]=='*'){
                        attribute[i] = attribute[i].substring(2);
                        resultALL = outLine(brackets(attribute[i]));    
                        //functionATT1 = (String) object.get(resultALL); 
                        
                        return operation;
                    }
                    else {
                        resultALL = attribute[i]; 
                        functionATT1 = (String) object.get(brackets(resultALL));
                    }
                //}

            if(resultALL != attribute[i]){
                //split
            }   
                
            if(functionATT1 == null){
                operation = operation.replaceFirst("\\?",brackets(resultALL));               
            }
            else {
                operation = operation.replaceFirst("\\?",functionATT1);
                }   
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
        String[] resultLin = null;
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
                    resultLine += simv[i];
                    break;
                }
                else {
                    resultLine += simv[i]; 

                } 
            }
        
        

        resultLin = text.split(resultLine);
        String tempTwoLine =  resultLine.substring(1,resultLine.length());
        tempTwoLine = "</" + tempTwoLine;

        String[] tempLines = resultLin[1].split(tempTwoLine);

        result = resultLine+"\n    "+tempLines[0] + "\n"+tempTwoLine;
        System.out.println(result);
        //System.out.println(result);
        //String tempLine = result.concat(resultLin[0]);
        //System.out.println(tempLine);    
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

