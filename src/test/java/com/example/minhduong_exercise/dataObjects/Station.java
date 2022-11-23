package com.example.minhduong_exercise.dataObjects;

public enum Station {
    SAIGON("Sài Gòn"),
    PHANTHIET("Phan Thiết"),
    NHATRANG("Nha Trang"),
    DANANG("Đà Nẵng"),
    HUE("Huế"),
    QUANGNGAI("Quảng Ngãi");

    public final String departStation;

    private Station(String departStation) {
        this.departStation = departStation;
    }

    public String getStation() {
        return this.departStation;
    }
}
