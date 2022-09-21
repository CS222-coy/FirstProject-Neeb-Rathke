package edu.bsu.cs222;

public class Revision {

    private String user;
    private String timeStamp;

    public Revision(String user, String timeStamp) {
        this.user = user;
        this.timeStamp = timeStamp;
    }


    public String getUser() {
        return user;
    }

    public void setAuthor(String author) {
        this.user = user;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}
