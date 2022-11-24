package com.example.minhduong_exercise.dataObjects;

public enum Message {
    WELCOME("Welcome abc@gmail.com"),
    FORM_ERROR("There was a problem with your login and/or errors exist in your form."),
    WRONG_ACCOUNT("Invalid username or password. Please try again."),
    MULTI_LOGIN("You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes."),
    REGISTER("You're here"),
    WRONG_INPUT("There're errors in the form. Please correct the errors and try again."),
    INVALID_PASS_LENGTH("Invalid password length"),
    INVALID_ID_LENGTH("Invalid ID length"),
    BOOK_TICKET_SUCCESS("Ticket Booked Successfully!"),
    CHANGE_PASS_SUCCESS("Your password has been updated!");

    public final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
