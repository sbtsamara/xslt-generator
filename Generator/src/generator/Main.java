package generator;

import static generator.Generator.choice;
import static generator.Generator.createXMLFile;
import static generator.Generator.readLine;

public class Main {
    
    public static void main(String[] args) {
        String[] cop = readLine();
        String text = choice(cop); 
        createXMLFile(text);
    }
}
