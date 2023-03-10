//package Note;
import java.awt.*;
import javax.swing.*;

public class About1 extends JFrame
{
    private Label label2;
    About1()
    {

        label2 = new Label("Creator by Filegeiasou");
        //this.setTitle("FileNotepad");
        this.setSize(200,200);
        //this.setResizeable(false);
        this.add(label2);
        this.setVisible(true);
    }
}