import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
public class KNNPredictor_4 {
    private int K;
    private int number_train;
    private int number_test;
    private ArrayList<DataPoint1> datapoint;
    private float truePositive,trueNegative,falsePositive,falseNegative;

    //constructor
    public KNNPredictor_4(int k){
        K=k;
        number_train=0;
        number_test=0;
        datapoint = new ArrayList<DataPoint1>();
        truePositive=0;
        trueNegative=0;
        falsePositive=0;
        falseNegative=0;
    }

    public List<String> getRecordFromLine(String line) {
            List<String> values = new ArrayList<String>();
            String str = "";
            int j = 0;
            int key = 0;
            int k = 0;
            for (int i = 0; i < line.length(); i++) {
                if (',' == line.charAt(i)) {
                    if (str.lastIndexOf("\"") > -1) {
                        if (j > 1) {
                            key = i;
                        }
                        j++;
                    }
                    if (str == null || str.equals("")) {
                        return null;
                    } else {
                        if (j == 2 && line.charAt(key + 1) == ',') {
                            j = 0;
                            key = 0;
                            values.add(str);
                            str = "";
                            continue;
                        } else if (j < 1) {
                            values.add(str);
                            str = "";
                            continue;
                        }
                    }
                }
                str += line.charAt(i);
            }
            values.add(str);
            str = "";
            return values;
    }


    public ArrayList<DataPoint1> readData() {
        boolean isTest;
        double sex=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("titanic(1).csv"));
            String line = br.readLine();
            System.out.println(line);
            while ((line = br.readLine()) != null) {
                List<String> records = getRecordFromLine(line);
                if(records == null)continue;
                String isSurvived = records.get(1);
                double age = Double.parseDouble(records.get(4));
                double fare = Double.parseDouble(records.get(5));
                double cc= Double.parseDouble(records.get(0));
                if(records.get(3).equals("female"))
                     sex= 1;
                else sex=0;
                Random rand = new Random();
                double randNum = rand.nextDouble();
                if (randNum < 0.9) {
                    isTest=false;
                    number_train++;
                } else {
                    isTest=true;
                }
                DataPoint1 data=new DataPoint1(age,fare,cc,sex,isSurvived,isTest);
                datapoint.add(data);
            }
        }
        catch (Exception ex){}
        System.out.println("number of training(4)="+number_train);
        return datapoint;
    }

    public double getDistance(DataPoint1 p1, DataPoint1 p2){
        return Math.sqrt(Math.pow(p1.getF1()-p2.getF1(), 2)+Math.pow(p1.getF2()-p2.getF2(),2)+
                Math.pow(p1.getF3()- p2.getF3(),2)+Math.pow(p1.getF4()- p1.getF4(),2));
    }

    public String test(DataPoint1 p1){
        String testResult;
        if(!p1.getTest()) return null;
        Double[][] arr=new Double[number_train][2];
        int i=0;
        for(DataPoint1 p2:datapoint){
            if(!p2.getTest()){
                double distance=getDistance(p1,p2);
                arr[i][0]=distance;
                arr[i][1]= Double.valueOf(p2.getLabel());
                i++;
            }
        }
        java.util.Arrays.sort(arr, Comparator.comparing(a -> a[0]));
        int s=0;
        int uns=0;
        for(int j=0;j<K;j++){
            if(arr[j][1]==1)  s++;
            else uns++;
        }

        if(s>uns) testResult="1";
        else testResult="0";

        if (testResult.equals("1")&&p1.getLabel().equals("1")) {
            truePositive++;
        }
        if (testResult.equals("1")&&p1.getLabel().equals("0")) {
            falsePositive++;
        }
        if (testResult.equals("0")&&p1.getLabel().equals("0")){
            trueNegative++;
        }
        if (testResult.equals("0")&&p1.getLabel().equals("1")){
            falseNegative++;
        }
        return  testResult;
    }

    public float getAccuracy(){
        float accuracy=(truePositive+trueNegative)/(trueNegative+truePositive+falseNegative+falsePositive);
        // System.out.print(truePositive+"and"+falseNegative+"and"+trueNegative);
        return accuracy;

    }

    public float getPrecision(){
        float precision=(truePositive) / (truePositive + falseNegative);
        // System.out.print(truePositive+"and"+falseNegative);
        return precision;
    }



}

