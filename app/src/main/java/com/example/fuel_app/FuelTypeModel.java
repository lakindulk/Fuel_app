package com.example.fuel_app;

public class FuelTypeModel {


    private String id;
    private String stationID;
    private String capacity;
    private String  fuelType;
    private String arrivalTime;
    private String finishTime;
    private String noOfFourweel;
    private String noOfSixweel;


    private String noOfThreeweel;
    private String noOfTwoweel;


    public FuelTypeModel(String id, String stationID, String capacity, String fuelType, String arrivalTime, String finishTime, String noOfFourweel, String noOfSixweel, String noOfThreeweel, String noOfTwoweel) {
        this.id = id;
        this.stationID = stationID;
        this.capacity = capacity;
        this.fuelType = fuelType;
        this.arrivalTime = arrivalTime;
        this.finishTime = finishTime;
        this.noOfFourweel = noOfFourweel;
        this.noOfSixweel = noOfSixweel;
        this.noOfThreeweel = noOfThreeweel;
        this.noOfTwoweel = noOfTwoweel;
    }
    public FuelTypeModel() {
    }

    @Override
    public String toString(){
        return "FuelTypeModel{"+
                "id='"+id+'\''+
                ", stationID='"+stationID+'\''+
                ", capacity='"+capacity+'\''+
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
    public String getCapacity() {
        return capacity;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }


    public void setCapacity(String capacity) {
        this.capacity = capacity;
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
