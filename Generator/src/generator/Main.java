package generator;

import windows.Form;
import static java.awt.EventQueue.invokeLater;

public class Main {
    public static void main(String[] args) {
        invokeLater(new Runnable() {
            public void run() {
                Form frame= new Form() ;
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setTitle("XSLT-generator");
            }
        });
    }
}