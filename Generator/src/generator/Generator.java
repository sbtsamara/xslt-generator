package generator;

import static generator.WorkJson.parseJson;
import windows.Form;

public class Generator {
    public static void General(){
        String[] command = null;
        String allResult = "";
        String text = Form.inputString;
        String[] commands = readWriteLine(text);
        for (String i:commands){
            command = readLine(i);
            String result = parseJson(command);
            allResult += result+"\r\n";
        }
        Form.outputString = allResult;
    }
    
    public static String[] readLine(String text){
        String[] cop = text.split(",");
        return cop;
    }
    
    public static String[] readWriteLine(String text){
        String[] cop = text.split("\n");
        return cop;
    }
}