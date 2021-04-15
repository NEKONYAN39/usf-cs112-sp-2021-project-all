
public class DataPoint {

    private Double f1;

    private Double f2;

    private String label;

    private Boolean isTest;

    public DataPoint() {
    }

    public DataPoint(Double f1, Double f2, String label, Boolean isTest) {
        this.f1 = f1;
        this.f2 = f2;
        this.label = label;
        this.isTest = isTest;
    }

    public Double getF1() {
        return f1;
    }

    public void setF1(Double f1) {
        this.f1 = f1;
    }

    public Double getF2() {
        return f2;
    }

    public void setF2(Double f2) {
        this.f2 = f2;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getTest() {
        return isTest;
    }

    public void setTest(Boolean test) {
        isTest = test;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(f1.toString()+" ");
        sb.append(f2.toString()+" ");
        if(label == null){
            sb.append(" ");
        }else {
            sb.append(label + " ");
        }
        sb.append(isTest+"\n");
        return sb.toString();
    }
}
