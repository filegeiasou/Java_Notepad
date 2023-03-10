package Notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class Notepad extends JFrame implements ActionListener 
{
    
    private JMenuBar menu;
    private JMenu file, options ,edit, about,theme;
    private JMenuItem save  , color , new1 ,open,save_as;
    private TextArea textarea;
    private FileDialog fd;
    private String filename , fileadd;
    Notepad()
    {
        menu = new JMenuBar();
        file = new JMenu("File");
        options = new JMenu("Options");
        edit = new JMenu("Edit");
        color = new JMenuItem("Color");
        save_as = new JMenuItem("Save as");
        save = new JMenuItem("Save");
        about = new JMenu("About");
        new1 = new  JMenuItem("New");
        theme= new JMenu("Theme");
        open = new JMenuItem("Open");
        theme.addActionListener(this);
        open.addActionListener(this);
        new1.addActionListener(this);
        save.addActionListener(this);
        save.setActionCommand("Save");
        save_as.addActionListener(this);
        about.addActionListener(this);
        textarea = new TextArea();


        file.add(new1);
        file.add(open);
        file.add(save_as);
        file.add(save);
        menu.add(file);
        edit.add(color);
        menu.add(edit);
        menu.add(options);
        menu.add(about);
        menu.add(theme);


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
        if(com=="Open")
        {
            fd = new FileDialog((this),"Open",FileDialog.LOAD);
            fd.setVisible(true);
            if(fd.getFile()!=null)
            {
                filename=fd.getFile();
                fileadd=fd.getDirectory();
                this.setTitle(filename);
                System.out.println("ok");
            }
                try
                {
                    BufferedReader br = new BufferedReader(new FileReader(fileadd + filename));

                    textarea.setText("");
                    String line = null;
                    while((line=br.readLine())!=null)
                    {
                        textarea.append(line+"\n");
                    }
                    br.close();
                }
                catch(Exception b)
                {
                    System.out.println("FILE DONT OPEN");
                }

        }
        else if(com=="Save as")
        {
                fd = new FileDialog((this),"Save",FileDialog.SAVE);
                fd.setVisible(true);
                if(fd.getFile()!=null)
                {
                    filename=fd.getFile();
                    fileadd=fd.getDirectory();
                    this.setTitle(filename);
                    System.out.println("ok");
                }
                try
                {
                    FileWriter fw = new FileWriter((fileadd + filename));
                    fw.write(textarea.getText());
                    
                    fw.close();
                }
                catch(Exception b)
                {
                    System.out.println("FILE DONT OPEN");
                }
        }
        else if(com=="Save")
        {
            if(filename==null)
            {
                System.out.println("ok");
            }
                try
                {
                    FileWriter fw = new FileWriter((fileadd + filename));
                    fw.write(textarea.getText());
                    this.setTitle(filename);
                    fw.close();
                }
                catch(Exception b)
                {
                    System.out.println("FILE DONT OPEN");
                }
        }
        else if(e.getSource()==about)
        {
            System.out.println("one");
            new About1();
        }
        else if(com=="New")
        {
            this.setTitle("FileNotepad New");
            filename=fileadd=null;
            textarea.setText("");
        }
        else if(e.getSource()==theme)
        {
            System.out.println("one1");
            textarea.setBackground(Color.lightGray);
            textarea.setVisible(true);
        }

    }    

    public static void main(String []args)
    {
        new Notepad();
        new About1();
    }
}
