package edu.bsu.cs222;

public class Revision {

    private String author;
    private String timeStamp;

    public Revision(String author, String timeStamp) {
        this.author = author;
        this.timeStamp = timeStamp;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}
