package generator;

import static generator.Creator.readLine;
import static generator.WorkJson.parseJson;
import windows.MainForm;

public class Generator {
    public static void General(){
       String[] cop = readLine();
       String result = parseJson(cop);
       MainForm.outputString = result;
    }
}
