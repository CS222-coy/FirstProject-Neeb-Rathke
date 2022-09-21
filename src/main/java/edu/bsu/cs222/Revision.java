package edu.bsu.cs222;

public class Revision {
        protected String author;
        protected String timestamp;

        public Revision(String author, String timestamp){
                this.author = author;
                this.timestamp = timestamp;
        }

        public String getAuthor() {
                return author;
        }

        public String getTimestamp() {
                return timestamp;
        }
}
