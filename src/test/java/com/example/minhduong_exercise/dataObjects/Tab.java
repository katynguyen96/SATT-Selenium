package com.example.minhduong_exercise.dataObjects;

public enum Tab {
    LOGIN("Login"),
    REGISTER("Register"),
    BOOKTICKET("Book ticket"),
    TICKETPRICE("Ticket price"),
    TIMETABLE("Timetable"),
    CONTACT("Contact"),
    FAQ("FAQ"),
    HOME("Home"),
    MYITCKET("My ticket"),
    CHANGEPASS("Change password"),
    LOGOUT("Log out");

    public final String tab;

    private Tab(String tab) {
        this.tab = tab;
    }

    public String getTabName() {
        return this.tab;
    }
}
