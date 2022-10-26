package com.example.fuel_app;
// manage the data related to the queue update
public class StationUpdateModel {

    private String id;
    private String stationId;
    private String vehicleType;
    private String noOfLiters;
    private String checkInTime;
    private String checkOutTime;

    public StationUpdateModel() {
    }

    public StationUpdateModel(String id, String stationId, String vehicleType, String noOfLiters, String checkInTime, String checkOutTime) {
        this.id = id;
        this.stationId = stationId;
        this.vehicleType = vehicleType;
        this.noOfLiters = noOfLiters;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getNoOfLiters() {
        return noOfLiters;
    }

    public void setNoOfLiters(String noOfLiters) {
        this.noOfLiters = noOfLiters;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
