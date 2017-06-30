package generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Generator {

    public static void main(String[] args) {
        String[] COP = readLine();
        String text = choice(COP); 
        createXMLFile(text);
        
    }
    
    public static String[] readLine(){
        Scanner scanner = new Scanner(System.in, "CP1251");
        System.out.print("Enter the operation: ");
        String text = scanner.nextLine();
        String[] COP = text.split(",");
    return COP;
    }
    
    public static String brackets(String bracket){
        String param = bracket.substring(1,bracket.length()-1);
        return param;
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
            
            
            
    public static String choice(String...COP){
        
        String text = null;
        switch(COP[0]){
            case "ЦИКЛ": 
                text = loop(brackets(COP[1]),brackets(COP[2]));
                break;
            case "ВЫБОР": choose(brackets(COP[1]),brackets(COP[2]),brackets(COP[3]),brackets(COP[4]));
                break;
            case "РАЗДЕЛИТЕЛЬ": format(brackets(COP[1]),brackets(COP[2])); 
                break;
            case "ВЫВОД": output(brackets(COP[1]),brackets(COP[2]),brackets(COP[3]));
                break;
            case "ИЗВЛЕЧЕНИЕ": valueOf(brackets(COP[1]));
                break;
            case "СОРТИРОВКА": sort(brackets(COP[1]),brackets(COP[2]));
                break;
            case "УСЛОВИЕ": condition(brackets(COP[1]),brackets(COP[2]));
                break;
            case "ПЕРЕМЕННАЯ": variable(brackets(COP[1]),brackets(COP[2]));
                break;
            case "ШАБЛОН": template(brackets(COP[1]),brackets(COP[2]),brackets(COP[3]));
                break;
            case "АТРИБУТ": attribute(brackets(COP[1]));
                break;
            case "ВЫЗОВ_ШАБЛОНА": callTemplate (brackets(COP[1]));
                break;
            case "ИМПОРТ_ШАБЛОНА": importTemplete (brackets(COP[1]));
                break;
                
            default: System.out.println("Invalid command");
                break;
        }
        return text;
    }
    
    public static String loop(String...value){
        String text = ""
                + "<xsl:for-each select = “"+value[0]+"” > \r\n" +
        ""+value[1]+"\r\n" +
        "</xsl:for-each>";
        return text;
    }
    
    public static void choose(String...value){
        System.out.println("\n"
                + "<xsl:choose>\n" +
            "                <xsl:when test= “"+value[0]+"” >\n" +
            "                   “"+value[1]+"”\n" +
            "                </xsl:when>\n" +
            "                <xsl:when test=“"+value[2]+"”>\n" +
            "                   “"+value[3]+"”\n" +
            "                </xsl:when>\n" +
            "                <xsl:otherwise>\n" +
            "                    “"+value[4]+"”\n" +
            "                </xsl:otherwise>\n" +
            "            </xsl:choose>");
    }
    
    public static void format(String...value){
        System.out.println("<xsl:decimal-format\n" +
            "    name = “"+value[0]+"” \n" +
            "    decimal-separator = “"+value[1]+"”\n" +
            " />");
    }
    public static void output(String...value){
        System.out.println("<xsl:output\n" +
            "    method = “"+value[0]+"”\n" +
            "    version = “"+value[1]+"”\n" +
            "    encoding = “"+value[2]+"”\n" +
            " />");
    }
    
    public static void valueOf(String...value){
        System.out.println("<xsl:value-of select=“"+value[0]+"”/>");
    }
    
    public static void sort(String...value){
        System.out.println("<xsl:sort\n" +
            "    	select = “"+value[0]+"”\n" +
            "    	order = “"+value[1]+"”\n" +
            "    	/>");
    }
    
    public static void condition(String...value){
        System.out.println("<xsl:if\n" +
            "    test = “"+value[0]+"”>\n" +
            "    “"+value[1]+"”\n" +
            "</xsl:if>");
    }
    
    public static void variable(String...value){
        System.out.println("<xsl:variable\n" +
            "    name = “"+value[0]+"”\n" +
            "    select = “"+value[1]+"”>\n" +
            "</xsl:variable>");
    }
    
    public static void template(String...value){
        System.out.println("<xsl:template\n" +
            "    match = “"+value[0]+"”\n" +
            "    name = “"+value[1]+"”\n" +
            "    “"+value[2]+"”\n" +
            "</xsl:template>");
    }
    
    public static void attribute(String...value){
        System.out.println("<xsl:attribute\n" +
            "    name = “"+value[0]+"”>\n" +
            "</xsl:attribute>");
    }
    
    public static void callTemplate(String...value){
        System.out.println("<xsl:apply-templates\n" +
            "    select = “"+value[0]+"”\n" +
            "</xsl:apply-templates>");
    }
    public static void importTemplete(String...value){
        System.out.println("<xsl:import href=“"+value[0]+"”/>\n" +
            "     <xsl:apply-imports/>");
    }
}

