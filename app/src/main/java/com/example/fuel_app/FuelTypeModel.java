package com.example.fuel_app;

public class FuelTypeModel {


    private String id;
    private String stationID;
    private String petrol92;
    private String  fuelType;
    private String arrivalTime;
    private String finishTime;
    private String noOfFourweel;
    private String noOfSixweel;
    private String noOfThreeweel;
    private String noOfTwoweel;
    private String petrol95;
    private String superDiesel;
    private String diesel;


    public void setDiesel(String diesel) {
        this.diesel = diesel;
    }

    public FuelTypeModel(String petrol95, String superDiesel, String diesel, String id, String stationID, String petrol92, String fuelType, String arrivalTime, String finishTime, String noOfFourweel, String noOfSixweel, String noOfThreeweel, String noOfTwoweel) {
        this.id = id;
        this.stationID = stationID;
        this.petrol92 = petrol92;
        this.fuelType = fuelType;
        this.arrivalTime = arrivalTime;
        this.finishTime = finishTime;
        this.noOfFourweel = noOfFourweel;
        this.noOfSixweel = noOfSixweel;
        this.noOfThreeweel = noOfThreeweel;
        this.noOfTwoweel = noOfTwoweel;
        this.petrol95 = petrol95;
        this.diesel = diesel;
        this.superDiesel = superDiesel;

    }
    public FuelTypeModel() {
    }

    @Override
    public String toString(){
        return "FuelTypeModel{"+
                "id='"+id+'\''+
                ", stationID='"+stationID+'\''+
                ", petrol92='"+petrol92+'\''+
                ", petrol95='"+petrol95+'\''+
                ", diesel='"+diesel+'\''+
                ", superDiesel='"+superDiesel+'\''+
                ", fuelType='"+fuelType+'\''+
                ", arrivalTime='"+arrivalTime+'\''+
                ", finishTime='"+finishTime+'\''+
                ", noOfFourweel='"+noOfFourweel+'\''+
                ", noOfSixweel='"+noOfSixweel+'\''+
                ", noOfThreeweel='"+noOfThreeweel+'\''+
                ", noOfTwoweel='"+noOfTwoweel+'\''+
                '}';
    }

    public String getId() {
        return id;
    }
    public String getPetrol92() {
        return petrol92;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public String getNoOfFourweel() {
        return noOfFourweel;
    }

    public String getNoOfSixweel() {
        return noOfSixweel;
    }

    public String getNoOfThreeweel() {
        return noOfThreeweel;
    }

    public String getNoOfTwoweel() {
        return noOfTwoweel;
    }

    public String getPetrol95() {
        return petrol95;
    }

    public void setPetrol95(String petrol95) {
        this.petrol95 = petrol95;
    }

    public String getSuperDiesel() {
        return superDiesel;
    }

    public void setSuperDiesel(String superDiesel) {
        this.superDiesel = superDiesel;
    }

    public String getDiesel() {
        return diesel;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }


    public void setPetrol92(String petrol92) {
        this.petrol92 = petrol92;
    }


    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }



    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }


    public void setNoOfFourweel(String noOfFourweel) {
        this.noOfFourweel = noOfFourweel;
    }



    public void setNoOfSixweel(String noOfSixweel) {
        this.noOfSixweel = noOfSixweel;
    }



    public void setNoOfThreeweel(String noOfThreeweel) {
        this.noOfThreeweel = noOfThreeweel;
    }



    public void setNoOfTwoweel(String noOfTwoweel) {
        this.noOfTwoweel = noOfTwoweel;
    }
}
