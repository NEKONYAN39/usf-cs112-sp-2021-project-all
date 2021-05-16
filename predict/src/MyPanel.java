import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class MyPanel extends JPanel {

    private ArrayList<DataPoint> listPoint = new ArrayList<>();

    private static final String LABEL_GOOD = "Good";
    private static final String LABEL_BAD = "Bad";

    private static final int START_X = 50;
    private static final int START_Y = 450;
    private static final int DElIVER = 40;

    private static final int R = 20; //画的圆的半径
    private static final int testR = 13; //画的圆的半径


    private static final int[][] line = {
            {50, 450}, {51, 445}, {53, 440}, {55, 430}, {58, 420}, {61, 414}, {64, 406}, {70, 395}, {74, 390}, {80, 385},
            {85, 378}, {89, 375}, {95, 370}, {100, 365}, {105, 360}, {110, 356}, {115, 352}, {120, 348}, {125, 344}, {130, 340},
            {140, 337}, {150, 334}, {160, 330}, {170, 327}, {180, 323}, {200, 318}, {220, 314}, {240, 310}, {260, 306}, {280, 300},
            {300, 292}, {320, 285}, {340, 278}, {360, 271}, {380, 260}, {400, 249}, {410, 237}, {420, 224}, {430, 210}, {440, 195}, {450, 179},
    };

    public MyPanel() {
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2d = (Graphics2D) graphics;
        paint11(g2d);
        listPoint.forEach(v -> {
            int rr;
            if (v != null) {
                if (v.getLabel().equals(this.LABEL_GOOD)) {
                    g2d.setColor(Color.green);
                } else {
                    g2d.setColor(Color.cyan);
                }
                // 区分点是否测试数据还是训练数据，训练数据大小是20，测试数据是13
                if(v.getTest()){
                    rr = testR;
                }else {
                    rr = R;
                }
                int x = START_X + v.getF1().intValue() * DElIVER;
                int y = START_Y - v.getF2().intValue() * DElIVER -20;
                g2d.fillOval(x, y, rr, rr);
            }
        });

    }

    //    @Override
    public void paint11(Graphics g) {
//        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.drawLine(50, 450, 460, 450);
        g2d.drawLine(50, 450, 50, 40);
        g2d.drawString("1", 35, 410);
        g2d.drawLine(50, 410, 60, 410);
        g2d.drawString("2", 35, 370);
        g2d.drawLine(50, 370, 60, 370);
        g2d.drawString("3", 35, 330);
        g2d.drawLine(50, 330, 60, 330);
        g2d.drawString("4", 35, 290);
        g2d.drawLine(50, 290, 60, 290);
        g2d.drawString("5", 35, 250);
        g2d.drawLine(50, 250, 60, 250);
        g2d.drawString("6", 35, 210);
        g2d.drawLine(50, 210, 60, 210);
        g2d.drawString("7", 35, 170);
        g2d.drawLine(50, 170, 60, 170);
        g2d.drawString("8", 35, 130);
        g2d.drawLine(50, 130, 60, 130);
        g2d.drawString("9", 35, 90);
        g2d.drawLine(50, 90, 60, 90);
        g2d.drawString("10", 35, 50);
        g2d.drawLine(50, 50, 60, 50);


        g2d.drawString("1", 87, 475);
        g2d.drawLine(90, 450, 90, 460);
        g2d.drawString("2", 127, 475);
        g2d.drawLine(130, 450, 130, 460);
        g2d.drawString("3", 167, 475);
        g2d.drawLine(170, 450, 170, 460);
        g2d.drawString("4", 207, 475);
        g2d.drawLine(210, 450, 210, 460);
        g2d.drawString("5", 247, 475);
        g2d.drawLine(250, 450, 250, 460);
        g2d.drawString("6", 287, 475);
        g2d.drawLine(290, 450, 290, 460);
        g2d.drawString("7", 327, 475);
        g2d.drawLine(330, 450, 330, 460);
        g2d.drawString("8", 367, 475);
        g2d.drawLine(370, 450, 370, 460);
        g2d.drawString("9", 407, 475);
        g2d.drawLine(410, 450, 410, 460);
        g2d.drawString("10", 445, 475);
        g2d.drawLine(450, 450, 450, 460);


        g2d.drawString(LABEL_GOOD, 400, 35);
        g2d.drawString(LABEL_BAD, 470, 35);
        g2d.setColor(Color.green);
        g2d.fillOval(440, 20, R, R);
        g2d.setColor(Color.cyan);
        g2d.fillOval(500, 20, R, R);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3.0f));
        for (int i = 1; i < line.length; i++) {
            g2d.drawLine(line[i - 1][0], line[i - 1][1], line[i][0], line[i][1]);
        }
        g2d.setStroke(new BasicStroke(1.0f));

    }

    public void drawDataPoint(DataPoint dataPoint) {
        this.listPoint.add(dataPoint);
        this.repaint();
    }

    public void addAll(ArrayList<DataPoint> listPoint) {
        this.listPoint.addAll(listPoint);
        this.repaint();
    }

    public int getY(int x) {
        return (1 + (x - 9 - START_X) * (x - 9 - START_X));
    }
}
