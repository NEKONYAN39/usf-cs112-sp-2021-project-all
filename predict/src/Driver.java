import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {

        //4 points
        KNNPredictor_4 knn = new KNNPredictor_4(20);
        ArrayList<DataPoint1> data=knn.readData();
        for(DataPoint1 d:data){
            knn.test(d);
       }
       System.out.println("Accuracy="+knn.getAccuracy());
       System.out.println("Precision="+knn.getPrecision());


           //2 points

           KNNFrame F=new KNNFrame();


    }

}
