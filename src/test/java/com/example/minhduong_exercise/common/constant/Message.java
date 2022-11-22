package com.example.minhduong_exercise.common.constant;

public enum Message {
    WELCOME("Welcome abc@gmail.com"),
    FORMERROR("There was a problem with your login and/or errors exist in your form."),
    WRONGACCOUNT("Invalid username or password. Please try again."),
    MULTILOGIN("You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes."),
    REGISTER("You're here"),
    WRONGINPUT("There're errors in the form. Please correct the errors and try again."),
    INVALIDPASSLENGTH("Invalid password length"),
    INVALIDIDLENGTH("Invalid ID length"),
    BOOKTICKETSUCCESS("Ticket Booked Successfully!"),
    CHANGEPASSSUCCESS("Your password has been updated");

    public final String message;

    private Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
