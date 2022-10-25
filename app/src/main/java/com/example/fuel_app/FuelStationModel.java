package com.example.fuel_app;

public class FuelStationModel {
    private String id;
    private String stationName;
    private String city;
    private String arrivaltime;
    private String FinishTime;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FuelStationModel(String id, String stationName, String city, String arrivaltime, String finishTime) {
        this.id = id;
        this.stationName = stationName;
        this.city = city;
        this.arrivaltime = arrivaltime;
        FinishTime = finishTime;
    }

    public FuelStationModel() {
    }

    @Override
    public String toString() {
        return "FuelStationModel{" +
                "id='" + id + '\'' +
                ", stationName='" + stationName + '\'' +
                ", city='" + city + '\'' +
                ", arrivaltime='" + arrivaltime + '\'' +
                ", FinishTime='" + FinishTime + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(String arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public String getFinishTime() {
        return FinishTime;
    }

    public void setFinishTime(String finishTime) {
        FinishTime = finishTime;
    }
}
