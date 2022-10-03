package edu.bsu.cs222;

public class Revision {

    private String user;
    private String timeStamp;
    private String redirect;

    public Revision(String user, String timeStamp, String redirect) {
        this.user = user;
        this.timeStamp = timeStamp;
        this.redirect = redirect;
    }

    public String getUser() {
        return user;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getRedirect() {
        return redirect;
    }
}
