import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class DummyPredictor extends Predictor {

    private static final int NUM = 10;

    private static final Random r = new Random();

    @Override
    ArrayList<DataPoint> readData(String filename) throws IOException {
        FileInputStream inputStream = null;
        BufferedReader bufferedReader = null;
        ArrayList<DataPoint> dataPoints = new ArrayList<>();
        try {
            inputStream = new FileInputStream(filename);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = bufferedReader.readLine())!=null){
                String[] s = line.split(" ");
                DataPoint dataPoint = new DataPoint(Double.parseDouble(s[0]),Double.parseDouble(s[1]),s[2],Boolean.parseBoolean(s[3]));
                dataPoints.add(dataPoint);
            }
        }catch (Exception e){

        }finally {
            if(inputStream != null){
                inputStream.close();
            }
            if(bufferedReader != null){
                bufferedReader.close();
            }
        }
        return dataPoints;
    }

    @Override
    public String test(DataPoint data) {
        return null;
    }

    @Override
    public Double getAccuracy(ArrayList<DataPoint> data) {
//        ArrayList<DataPoint> dataPoints = new ArrayList<>();
        for (int i = 1;i<=NUM;i++){
            data.add(this.getRandom(true));
        }
        return data.get(0).getF1();
    }

    @Override
    public Double getPrecision(ArrayList<DataPoint> data) {
        for (int i = 1;i<=NUM;i++){
            data.add(this.getRandom(false));
        }
        return null;
    }


    public static DataPoint getRandom(boolean needLabel){
        DataPoint dataPoint = new DataPoint();
        double f1 = r.nextInt(10);
        double f2 = r.nextInt(10);
        dataPoint.setF1(f1);
        dataPoint.setF2(f2);
        if (needLabel){
            dataPoint.setTest(false);
            if(r.nextInt(10)%2==0){
                dataPoint.setLabel("Good");
            }else {
                dataPoint.setLabel("Bad");
            }
        }else {
            dataPoint.setTest(true);
        }

        return dataPoint;
    }
}
