package generator;

import windows.*;

public class Creator {  
    public static String[] readLine(){
        String text = Form.inputString;
        String[] cop = text.split(",");
        return cop;
    }
}