package com.example.minhduong_exercise.common.constant;

public enum ArriveStationConstant {
    SAIGON("Sài Gòn"),
    PHANTHIET("Phan Thiết"),
    NHATRANG("Nha Trang"),
    DANANG("Đà Nẵng"),
    HUE("Huế"),
    QUANGNGAI("Quảng Ngãi");

    public final String arriveStation;

    private ArriveStationConstant(String arriveStation) {
        this.arriveStation = arriveStation;
    }

    public String getTabName() {
        return this.arriveStation;
    }
}
