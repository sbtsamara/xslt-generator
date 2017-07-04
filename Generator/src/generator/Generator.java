package generator;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Properties;
import static generator.Creator.createXMLFile;
import static generator.Creator.readLine;
import static generator.WorkJson.parseJson;
import org.json.simple.JSONObject;


public class Generator {
    
    public static void General(){
 
       String[] cop = readLine();
       String result = parseJson(cop);
       // String text = WorkWithJson(cop);
       createXMLFile(result);
    }
}

   // public static final String PATH_TO_PROPERTIES = "src/resources/config.properties";

    /*public static String WorkWithJson(String...cop){
    
    
    
    
    FileInputStream fileInputStream;
    
    Properties prop = new Properties();
    String text=null;
    
    try {
    fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
    Charset.forName("UTF-8");
    prop.load(fileInputStream);
    
    String op = cop[0];
    
    text = prop.getProperty(op);
    
    
    } catch (IOException e) {
    System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружено");
    e.printStackTrace();
    }
    return text;*/
/*
        switch(cop[0]){
            case "ЦИКЛ":
                text = loop(brackets(cop[1]),brackets(cop[2]));
                break;
            case "ВЫБОР": choose(brackets(cop[1]),brackets(cop[2]),brackets(cop[3]),brackets(cop[4]));
                break;
            case "РАЗДЕЛИТЕЛЬ": format(brackets(cop[1]),brackets(cop[2]));
                break;
            case "ВЫВОД": output(brackets(cop[1]),brackets(cop[2]),brackets(cop[3]));
                break;
            case "ИЗВЛЕЧЕНИЕ": valueOf(brackets(cop[1]));
                break;
            case "СОРТИРОВКА": sort(brackets(cop[1]),brackets(cop[2]));
                break;
            case "УСЛОВИЕ": condition(brackets(cop[1]),brackets(cop[2]));
                break;
            case "ПЕРЕМЕННАЯ": variable(brackets(cop[1]),brackets(cop[2]));
                break;
            case "ШАБЛОН": template(brackets(cop[1]),brackets(cop[2]),brackets(cop[3]));
                break;
            case "АТРИБУТ": attribute(brackets(cop[1]));
                break;
            case "ВЫЗОВ_ШАБЛОНА": callTemplate (brackets(cop[1]));
                break;
            case "ИМПОРТ_ШАБЛОНА": importTemplete (brackets(cop[1]));
                break;
        
            default: System.out.println("Invalid command");
                break;
        }
    }
*/
    

    
    
    
    /*
    private static String loop(String...value){
    String text = ""
    + "<xsl:for-each select = “"+value[0]+"” > \r\n" +
    ""+value[1]+"\r\n" +
    "</xsl:for-each>";
    return text;
    }
    
    private static void choose(String...value){
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
    
    private static void format(String...value){
    System.out.println("<xsl:decimal-format\n" +
    "    name = “"+value[0]+"” \n" +
    "    decimal-separator = “"+value[1]+"”\n" +
    " />");
    }
    private static void output(String...value){
    System.out.println("<xsl:output\n" +
    "    method = “"+value[0]+"”\n" +
    "    version = “"+value[1]+"”\n" +
    "    encoding = “"+value[2]+"”\n" +
    " />");
    }
    
    private static void valueOf(String...value){
    System.out.println("<xsl:value-of select=“"+value[0]+"”/>");
    }
    
    private static void sort(String...value){
    System.out.println("<xsl:sort\n" +
    "    	select = “"+value[0]+"”\n" +
    "    	order = “"+value[1]+"”\n" +
    "    	/>");
    }
    
    private static void condition(String...value){
    System.out.println("<xsl:if\n" +
    "    test = “"+value[0]+"”>\n" +
    "    “"+value[1]+"”\n" +
    "</xsl:if>");
    }
    
    private static void variable(String...value){
    System.out.println("<xsl:variable\n" +
    "    name = “"+value[0]+"”\n" +
    "    select = “"+value[1]+"”>\n" +
    "</xsl:variable>");
    }
    
    private static void template(String...value){
    System.out.println("<xsl:template\n" +
    "    match = “"+value[0]+"”\n" +
    "    name = “"+value[1]+"”\n" +
    "    “"+value[2]+"”\n" +
    "</xsl:template>");
    }
    
    private static void attribute(String...value){
    System.out.println("<xsl:attribute\n" +
    "    name = “"+value[0]+"”>\n" +
    "</xsl:attribute>");
    }
    
    private static void callTemplate(String...value){
    System.out.println("<xsl:apply-templates\n" +
    "    select = “"+value[0]+"”\n" +
    "</xsl:apply-templates>");
    }
    private static void importTemplete(String...value){
    System.out.println("<xsl:import href=“"+value[0]+"”/>\n" +
    "     <xsl:apply-imports/>");
    }
    }
    */