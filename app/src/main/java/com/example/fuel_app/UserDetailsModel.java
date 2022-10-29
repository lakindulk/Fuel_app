package com.example.fuel_app;

public class UserDetailsModel {
    private String id;
    private String vehicleNb;
    private String vehicleType;
    private String fuelType;
    private String chesisNb;

    public UserDetailsModel() {
    }

    public UserDetailsModel(String id, String vehicleNb, String vehicleType, String fuelType, String chesisNb) {
        this.id = id;
        this.vehicleNb = vehicleNb;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.chesisNb = chesisNb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleNb() {
        return vehicleNb;
    }

    public void setVehicleNb(String vehicleNb) {
        this.vehicleNb = vehicleNb;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getChesisNb() {
        return chesisNb;
    }

    public void setChesisNb(String chesisNb) {
        this.chesisNb = chesisNb;
    }
}
