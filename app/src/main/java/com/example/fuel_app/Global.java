package com.example.fuel_app;

public class Global {
    private static final Global instance = new Global();

    public static Global getInstance() {
        return instance;
    }

    private String data;
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
