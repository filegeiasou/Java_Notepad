package Notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Notepad extends JFrame implements ActionListener
{
    
    private JMenuBar menu;
    private JMenu file, options ,edit, about;
    private JMenuItem save  , color , new1 ;
    private TextArea textarea;
    private FileDialog fd;
    Notepad()
    {
        menu = new JMenuBar();
        file = new JMenu("File");
        options = new JMenu("Options");
        edit = new JMenu("Edit");
        color = new JMenuItem("Color");
        save = new JMenuItem("Save");
        about = new JMenu("About");
        new1 = new  JMenuItem("New");
        new1.addActionListener(this);
        save.addActionListener(this);
        textarea = new TextArea();


        file.add(new1);
        file.add(save);
        menu.add(file);
        edit.add(color);
        menu.add(edit);
        menu.add(options);
        menu.add(about);


        this.setJMenuBar(menu);

        this.add(textarea);
        this.setSize(800,800);
        this.setTitle("FileNotepad");
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String com = e.getActionCommand();
        if(com=="New")
        {
            fd = new FileDialog((this),"New",FileDialog.LOAD);
            fd.setVisible(true);
        }
        else if(com=="Save")
        {
            fd = new FileDialog((this),"Save",FileDialog.SAVE);
            fd.setVisible(true);
        }
    }
}
