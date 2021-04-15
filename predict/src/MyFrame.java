import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

public class MyFrame extends JFrame {

    public static final String MESSAGE = "message: ";

    public static final MyPanel myPanel1 = new MyPanel();
    public static final Label b1 = new Label(MESSAGE);

    public MyFrame(String title,int width, int height) throws IOException {
        super(title);
        this.setSize(width,height);
        this.setLayout(new BorderLayout());

        b1.setSize(100,20);
        Panel myPanel = new Panel();
        myPanel.setSize(300,225);
        myPanel.add(b1);
        this.add(myPanel,BorderLayout.NORTH);

        this.add(myPanel1,BorderLayout.CENTER);



        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);


    }



}
