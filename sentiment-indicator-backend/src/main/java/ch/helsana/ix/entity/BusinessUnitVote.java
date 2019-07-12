package ch.helsana.ix.entity;

public class BusinessUnitVote {
    private String businessUnit;
    private double avg;

    public BusinessUnitVote(String businessUnit, double avg) {
        this.businessUnit = businessUnit;
        this.avg = avg;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public double getAvg() {
        return avg;
    }

    public void setMedian(double avg) {
        this.avg = avg;
    }
}