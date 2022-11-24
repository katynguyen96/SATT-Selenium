package com.example.minhduong_exercise.dataObjects;

public enum Url {
    HOMEPAGE("http://railwayb2.somee.com/Page/HomePage.cshtml"),
    NOT_LOGIN("http://railwayb2.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml"),
    FAQ("http://railwayb2.somee.com/Page/FAQ.cshtml#"),
    CONTACT("http://railwayb2.somee.com/Page/Contact.cshtml"),
    TIMETABLE("http://railwayb2.somee.com/Page/TrainTimeListPage.cshtml"),
    TICKET_PRICE("http://railwayb2.somee.com/Page/TrainPriceListPage.cshtml"),
    REGISTER("http://railwayb2.somee.com/Account/Register.cshtml"),
    LOGIN("http://railwayb2.somee.com/Account/Register.cshtml"),
    BOOK_TICKET("http://railwayb2.somee.com/Page/BookTicketPage.cshtml"),
    MY_TICKET("http://railwayb2.somee.com/Page/ManageTicket.cshtml"),
    CHANGE_PASSWORD("http://railwayb2.somee.com/Account/ChangePassword.cshtml");

    public final String Url;

    Url(String Url) {
        this.Url = Url;
    }

    public String getUrl() {
        return this.Url;
    }
}
