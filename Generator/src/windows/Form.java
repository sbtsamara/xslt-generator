package windows;

import static generator.Generator.General;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Short.MAX_VALUE;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

public class Form extends JFrame {
    private String text = "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"> \r\n";
    public JTextArea inputField = new JTextArea();
    public JTextArea outputField = new JTextArea();
    public static String inputString;
    public static String outputString; 
    
    public Form() {
        initComponents();
    } 
    @SuppressWarnings("unchecked")
    
    public void initComponents() {

        JButton jButton1 = new JButton();
        JScrollPane jScrollPane1 = new JScrollPane();
        JScrollPane jScrollPane2 = new JScrollPane();
        Button button1 = new Button();
        //JButton jButton2 = new JButton();
        JMenuBar jMenuBar1 = new JMenuBar();
        JMenu jMenu1 = new JMenu();
        JMenuItem jMenuItem1 = new JMenuItem();
        JMenuItem jMenuItem2 = new JMenuItem();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jButton1.setText("Перевести в XSL →");
        jButton1.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        inputField.setColumns(20);
        inputField.setRows(5);
        jScrollPane1.setViewportView(inputField);
        outputField.setColumns(20);
        outputField.setRows(5);
        jScrollPane2.setViewportView(outputField);
        button1.setLabel("button1");
        jMenuBar1.setBackground(new Color(204, 204, 204));
        jMenu1.setText("File");
        jMenuItem1.setText("Сохранить");
        jMenuItem1.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenuItem2.setText("Выход");
        jMenuItem2.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenuBar1.add(jMenu1);
        setJMenuBar(jMenuBar1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, PREFERRED_SIZE, 257, PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButton1, PREFERRED_SIZE, 163, PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, DEFAULT_SIZE, 452, MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, PREFERRED_SIZE, 315, PREFERRED_SIZE)
                        .addPreferredGap(RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        pack();
    }                      
    public void jButton1ActionPerformed(ActionEvent evt) { 
        inputString = inputField.getText();
        General();
        outputField.setText(text+outputString);
    }                                        
    
    private void jMenuItem1ActionPerformed(ActionEvent evt) {                                           
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  
        int temp = fc.showSaveDialog(null);
        
        String path = fc.getSelectedFile().getAbsolutePath();

        try(FileWriter writer = new FileWriter(path, false)){
            writer.write(text);
            writer.write(outputString);
            writer.flush();
        } catch(IOException ex){ 
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, "Ошибка при записи", ex);
       }
        
        
        if(temp == JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(fc, "Файл сохранён");
        }
        
    }  
    
    private void jMenuItem2ActionPerformed(ActionEvent evt) {                                           
        dispose();
    } 
}