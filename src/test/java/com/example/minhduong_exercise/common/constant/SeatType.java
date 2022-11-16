package com.example.minhduong_exercise.common.constant;

public enum SeatType {
    HS("Hard seat"),
    SS("Soft seat"),
    SSWAC("Soft seat with air conditioner"),
    HB("Hard bed"),
    SB("Soft bed"),
    SBWAC("Soft bed with air conditioner");

    public final String seatType;

    private SeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getSeatType() {
        return this.seatType;
    }
}
