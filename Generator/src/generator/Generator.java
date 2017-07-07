package generator;

import static generator.Creator.readLine;
import static generator.WorkJson.parseJson;
import windows.Form;

public class Generator {
    public static void General(){
       String[] cop = readLine();
       String result = parseJson(cop);
       Form.outputString = result;
    }
}