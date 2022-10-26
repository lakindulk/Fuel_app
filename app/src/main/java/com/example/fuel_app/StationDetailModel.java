package com.example.fuel_app;
// this model handles the data related to the fuel stations
public class StationDetailModel {
    private String id;
    private String stationId;
    private String arrivalTime;
    private String finishTime;
    private String petrol95;
    private String petrol92;
    private String diesel;
    private String superDiesel;

    public StationDetailModel() {
    }

    public StationDetailModel(String id, String stationId, String arrivalTime, String finishTime, String petrol95, String petrol92, String diesel, String superDiesel) {
        this.id = id;
        this.stationId = stationId;
        this.arrivalTime = arrivalTime;
        this.finishTime = finishTime;
        this.petrol95 = petrol95;
        this.petrol92 = petrol92;
        this.diesel = diesel;
        this.superDiesel = superDiesel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getPetrol95() {
        return petrol95;
    }

    public void setPetrol95(String petrol95) {
        this.petrol95 = petrol95;
    }

    public String getPetrol92() {
        return petrol92;
    }

    public void setPetrol92(String petrol92) {
        this.petrol92 = petrol92;
    }

    public String getDiesel() {
        return diesel;
    }

    public void setDiesel(String diesel) {
        this.diesel = diesel;
    }

    public String getSuperDiesel() {
        return superDiesel;
    }

    public void setSuperDiesel(String superDiesel) {
        this.superDiesel = superDiesel;
    }
}
