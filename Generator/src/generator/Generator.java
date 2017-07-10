package generator;

import static generator.WorkJson.parseJson;
import windows.Form;

public class Generator {
    public static void General(){
       String text = Form.inputString;
       String[] cop = readLine(text);
       String result = parseJson(cop);
       Form.outputString = result;
    }
    
    public static String[] readLine(String text){
        String[] cop = text.split(",");
        return cop;
    }
}