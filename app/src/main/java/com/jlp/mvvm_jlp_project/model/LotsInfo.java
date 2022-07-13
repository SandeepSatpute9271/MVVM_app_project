package com.jlp.mvvm_jlp_project.model;

public class LotsInfo {

    private String lotNumber = new String();
    private String lotLocation = new String();


    public LotsInfo() {
    }

    public LotsInfo(String lotNumber, String lotLocation) {
        this.lotNumber = lotNumber;
        this.lotLocation = lotLocation;
    }

    public String getLotNumber() {
        return lotNumber;
    }


    public static LotsInfo getCopy(LotsInfo lot) {
        return new LotsInfo(lot.lotNumber, lot.lotLocation);
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getLotLocation() {
        return lotLocation;
    }

    public void setLotLocation(String lotLocation) {
        this.lotLocation = lotLocation;
    }
}
