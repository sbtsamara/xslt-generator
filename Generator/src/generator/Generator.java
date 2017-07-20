package generator;

import static generator.WorkJson.parseJson;
import windows.Form;

public class Generator {
    
    public static void General(){
        String[] command = null ;
        String ourResult = "";
        String inputcode = Form.inputString;
        String[] generalCommands = readWriteLines(inputcode);
        for (String i:generalCommands){
            command = readLine(i);
            String result = parseJson(command);
            ourResult += result;
        }
        Form.outputString = ourResult;
    }
    
    public static String[] readLine(String text){
        String[] commands = text.split(",");
        return commands;
    }
    
    public static String[] readWriteLines(String text){
        String[] commands = text.split(";\n");
        return commands;
    }
}
