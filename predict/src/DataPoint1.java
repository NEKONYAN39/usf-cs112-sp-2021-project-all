public class DataPoint1 {

    private Double f1;

    private Double f2;

    private Double f3;

    private Double f4;

    private String label;

    private Boolean isTest;

    public DataPoint1() {
    }

    public DataPoint1(Double f1, Double f2,Double f3, Double f4,String label, Boolean isTest) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
        this.label=label;
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

    public Double getF3() {
        return f3;
    }

    public void setF3(Double f3) {
        this.f3 = f3;
    }

    public Double getF4() {
        return f4;
    }

    public void setF4(Double f4) {
        this.f4 = f4;
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

}
