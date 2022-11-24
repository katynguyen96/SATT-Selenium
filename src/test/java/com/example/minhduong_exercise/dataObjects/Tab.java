package com.example.minhduong_exercise.dataObjects;

public enum Tab {
    LOGIN("Login"),
    REGISTER("Register"),
    BOOK_TICKET("Book ticket"),
    TICKET_PRICE("Ticket price"),
    TIME_TABLE("Timetable"),
    CONTACT("Contact"),
    FAQ("FAQ"),
    HOME("Home"),
    MY_TICKET("My ticket"),
    CHANGE_PASSWORD("Change password"),
    LOGOUT("Log out");

    public final String tab;

    Tab(String tab) {
        this.tab = tab;
    }

    public String getTabName() {
        return this.tab;
    }
}
