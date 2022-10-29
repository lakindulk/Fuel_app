package com.example.fuel_app;
// this model handles the data objects related to the fuel station details model
public class FuelStationModel {
    private String id;
    private String stationName;
    private String city;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FuelStationModel(String id, String stationName, String city) {
        this.id = id;
        this.stationName = stationName;
        this.city = city;

    }

    public FuelStationModel() {
    }

    @Override
    public String toString() {
        return "FuelStationModel{" +
                "id='" + id + '\'' +
                ", stationName='" + stationName + '\'' +
                ", city='" + city + '\'' +

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


}
