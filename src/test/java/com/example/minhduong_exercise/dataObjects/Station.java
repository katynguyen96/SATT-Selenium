package com.example.minhduong_exercise.dataObjects;

public enum Station {
    SAI_GON("Sài Gòn"),
    PHAN_THIET("Phan Thiết"),
    NHA_TRANG("Nha Trang"),
    DA_NANG("Đà Nẵng"),
    HUE("Huế"),
    QUANG_NGAI("Quảng Ngãi");

    public final String departStation;

    private Station(String departStation) {
        this.departStation = departStation;
    }

    public String getStation() {
        return this.departStation;
    }
}
