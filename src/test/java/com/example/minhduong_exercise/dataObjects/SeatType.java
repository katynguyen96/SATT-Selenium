package com.example.minhduong_exercise.dataObjects;

public enum SeatType {
    HS("Hard seat"),
    SS("Soft seat"),
    SSC("Soft seat with air conditioner"),
    HB("Hard bed"),
    SB("Soft bed"),
    SBC("Soft bed with air conditioner");

    public final String seatType;

    private SeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getSeatType() {
        return this.seatType;
    }
}
