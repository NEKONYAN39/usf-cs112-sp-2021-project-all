import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static final String saveFile= "save.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        //Generate two sets of random DataPoints, one being the training data set, one being the
        //test data set. Store the points into a text file you can read. For example, a file can
        //contain values in the format (f1 f2 label isTest) as follows
        doSaveDataToFile();
        DummyPredictor dummyPredictor = new DummyPredictor();
        ArrayList<DataPoint> dataPoints1 = new ArrayList<>();
        //获取训练数据集
        dummyPredictor.getAccuracy(dataPoints1);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MyFrame f = new MyFrame("JFrame Title",600,600);
//                    DummyPredictor dummyPredictor = new DummyPredictor();
//                    ArrayList<DataPoint> dataPoints = dummyPredictor.readData(Main.saveFile);
//                    dataPoints.forEach(v->{
//                        MyFrame.myPanel1.drawDataPoint(v);
//                    });
                    MyFrame.b1.setText(MyFrame.MESSAGE + "show the random data");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 展示训练数据集
                    MyFrame.myPanel1.addAll(dataPoints1);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread.sleep(4000);
        // 展示测试数据
        ArrayList<DataPoint> dataPoints2 = new ArrayList<>();
        dummyPredictor.getPrecision(dataPoints2);
        dataPoints2.forEach(v->{
            MyFrame.b1.setText(MyFrame.MESSAGE + "test " + v.toString());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            precision(dataPoints1,v);
            MyFrame.myPanel1.drawDataPoint(v);

        });
    }

    // 去训练数据最近的点的标签作为测试点的标签
    public static void precision(ArrayList<DataPoint> accuracy, DataPoint test){
        double f1 = test.getF1();
        double f2 = test.getF2();
        Double distance = null;
        for (int i = 0;i<accuracy.size();i++){
            DataPoint accuracyPoint = accuracy.get(i);
            double v1 = f1 - accuracyPoint.getF1();
            double v2 = f2 - accuracyPoint.getF2();
            double sqrt = Math.sqrt((v1 * v1) + (v2 * v2));
            if(distance == null || sqrt < distance){
                test.setLabel(accuracyPoint.getLabel());
                distance = sqrt;
            }
        }
    }

    // 将数据save入文件
    public static void doSaveDataToFile() throws IOException {
        DataPoint random1 = new DataPoint(1.0, 1.0, "Good", true);
        DataPoint random2 = new DataPoint(2.0, 2.0, "Bad", false);
        File file = new File(saveFile);
        FileWriter fileWriter = null; //输出流，用于写入文件
        try {
            if (!file.exists()) {
                // 如果文件不存在，则创建
                file.createNewFile();
            }
            fileWriter = new FileWriter(file);
            String str = random1.toString();
            fileWriter.write(str);
            str = random2.toString();
            fileWriter.write(str);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fileWriter != null){
                fileWriter.close();
            }
        }
    }
}
