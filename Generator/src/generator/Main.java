package generator;
import static generator.Generator.General;
import windows.MainForm;

public class Main {
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
        //General();
    }
}
