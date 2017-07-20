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
    public static ArrayList <String> spaceList = new ArrayList();
    public static int spaceAmound = -1;
    public static JSONObject object = new JSONObject();
    
    public static String parseJson(String[] attribute){
        JSONParser parser = new JSONParser();
        String construction = null;
        String function = null;
        String tegs = null;
        
        try {
            object = (JSONObject) parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME), "UTF8")));      
            construction = (String) object.get(attribute[0]);
        }
        catch (IOException | ParseException ex) {
            Logger.getLogger(WorkJson.class.getName()).log(Level.SEVERE, "Неверный путь к файлу Json", ex);    
        }   
            if (construction==null){
                construction = "Операция не найдена. Повторите попытку.";
                return construction;
            }
            
            if(attribute.length == 1){
                construction = construction.replace("?","");
                return construction;
            }
            for (int i = 1; i < attribute.length; i++) {
                    attribute[i] = attribute[i].replace("\n","");
                    char[] charsFunction = attribute[i].toCharArray();

                    if(charsFunction[1]=='<'){
                        tegs = findTegs(checkFormat(attribute[i]));    
                        construction = construction.replaceFirst("\\?", tegs);
                    }
                    else { 
                        function = (String) object.get(checkFormat(attribute[i]));   

                        if(function == null){
                            construction = construction.replaceFirst("\\?", checkFormat(attribute[i]));               
                        }
                        else {
                            construction = construction.replaceFirst("\\?", function);
                        }   
                    }
            } 
            
        construction = outLine(construction);
        return construction;
    }
    
    public static String outLine(String text){
        String[] str = text.split("\n");
        text ="";
        for (int j = 0; j < str.length; j++) {
            if(!(str[j].length()==4 && str[j].contains("    "))){
                text = text + str[j] + "\n";
            }
            
        }
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
            text = text.replace("    ?","");
        }
        return text;
    }
    
    public static String checkFormat(String bracket){
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
    
    public static String findTegs(String text){ 
        spaceAmound++;
        
        if(spaceList.size()>spaceAmound){
            spaceList.set(spaceAmound, space);
        }else{
            spaceList.add(space);
        }
        
        space += "    ";
        String StrTegs = "";
        String[] StrWithoutOpeningTeg = new String[5];
        String openTeg = null;
        
        openTeg = readTeg(text);

        if (openTeg.equals(text)){
            String functionInTeg = (String) object.get(checkFormat(openTeg));
            if (functionInTeg!=null){
                StrTegs = "\n" + space + functionInTeg;
                return StrTegs;
            } else StrWithoutOpeningTeg[1] = openTeg;
        }
        else{ 
            StrWithoutOpeningTeg = text.split(openTeg);
        }
        
        String closeTeg =  openTeg.substring(1,openTeg.length());
        closeTeg = "</" + closeTeg;
        String[] ContentTegs = StrWithoutOpeningTeg[1].split(closeTeg);

        if (!ContentTegs[0].equals(StrWithoutOpeningTeg[1])){
            StrTegs = "\n" + space + openTeg + space + space + outLine(ContentTegs[0]) + "\n" + spaceList.get(spaceAmound) + closeTeg;
            spaceAmound--;
        }
        else{
            StrTegs = "\n" + space + openTeg;
        }
                
        if(ContentTegs.length>1){
            space = "";
            StrTegs += outLine(ContentTegs[1]);
        }
        space = "";
        return StrTegs;
    }
    
    public static String readTeg(String text){
        char[] charsTegs = text.toCharArray();
        String openTeg = "";
        
        
        for (int i = 0; i < charsTegs.length; i++) {
                if(charsTegs[i] == '<'){
                    while (charsTegs[i] != '>'){
                        openTeg += charsTegs[i]; 
                        i++;
                    }
                    openTeg += charsTegs[i];
                    break;
                }
                else {
                    openTeg += charsTegs[i]; 
                } 
        }
        return openTeg;
    }
}
