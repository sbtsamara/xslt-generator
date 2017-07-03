package generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Creator {
    
     public static String[] readLine(){
        Scanner scanner = new Scanner(System.in, "CP1251"); //"CP1251","utf-8"
        System.out.print("Enter the operation: ");
        String text = scanner.nextLine();
        String[] cop = text.split(",");
        return cop;
    }
     
     public static void createXMLFile(String text2){

        File dir = new File("C://Users//usersbt//Downloads//File.xsl");
        File file = new File(dir, "File.xsl");
        try(FileWriter writer = new FileWriter(dir, false))
        {
            String text = "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"> \r\n";
            writer.write(text);
            writer.write(text2);
            System.out.print(text + text2);
            writer.flush();
        }
        catch(IOException ex){  System.out.println(ex.getMessage());}
    }
}
