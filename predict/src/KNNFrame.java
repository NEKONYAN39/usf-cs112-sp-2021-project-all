import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class KNNFrame extends JFrame {
    private JTextField textField;
    private String str;
    private KNNPredictor knn;
    private JFrame f;
    private JPanel panel1, panel2;
    private JButton button;
    private float accuracy,precision;

    public KNNFrame() {

        f = new JFrame("KNN Prediction");
        f.getContentPane().setLayout(new FlowLayout());
        f.setBounds(300, 100, 300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel j0=new JLabel("Please Input Value of K:");
        textField = new JTextField(16);
        button = new JButton("OK");

        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setSize(100, 100);
        panel1.setBackground(Color.white);

        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.setSize(100, 100);
        panel2.setBackground(Color.white);

        f.add(j0);
        f.add(textField);
        f.add(button);
        f.setVisible(true);
        button.addActionListener((e) -> {
            onButtonOk();
        });
    }

    private void refreshKNN() {
        panel1.removeAll();
        panel2.removeAll();
        JLabel jl = new JLabel("Accuracy: "+accuracy );
        JLabel jl1 = new JLabel("Precision: "+precision);
        panel1.add(jl, BorderLayout.CENTER);
        panel2.add(jl1, BorderLayout.CENTER);
        f.add(panel1);
        f.add(panel2);
        f.setVisible(true);
    }

    private void onButtonOk() {
        str = textField.getText();
        if (str.equals("")) {
            Object[] options = {"OK ", "CANCEL "};
            JOptionPane.showOptionDialog(null, "No text ", "Tip", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        } else
            JOptionPane.showMessageDialog(null, "You set K:" + str);
        knn = new KNNPredictor(Integer.parseInt(str));
        Show();
        refreshKNN();

    }

    public void Show() {
        ArrayList<DataPoint> data = knn.readData();
        for (DataPoint d : data) {
            knn.test(d);
            if (d.getTest()) {
                knn.test(d);
            }
        }
        accuracy=knn.getAccuracy();
        precision=knn.getPrecision();

    }


}

