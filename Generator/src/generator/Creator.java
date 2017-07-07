package generator;

import windows.*;

public class Creator {  
    public static String[] readLine(){
        String text = MainForm.inputString;
        String[] cop = text.split(",");
        return cop;
    }
}
