package com.example.minhduong_exercise.common.constant;

public enum AssertMessage {
    ELEMENT_NOT_DISPLAY("This element is not display on UI"),
    ELEMENT_DISPLAY("This element is display on UI");

    public final String message;

    private AssertMessage(String message) {
        this.message = message;
    }

    public String getAssertMessage() {
        return this.message;
    }
}
