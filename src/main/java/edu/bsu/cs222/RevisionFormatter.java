package edu.bsu.cs222;

public class RevisionFormatter {

    public static String Formatter(Revision[] revisionList, int numberOfRevisions) {
        String formattedString = "";

        //Revisions formatted to show each timestamp and the user/author
        for (int i = 0; i < numberOfRevisions; i++) {
           formattedString = formattedString + revisionList[i].getTimeStamp() + " " + revisionList[i].getUser() + "\n";
        }
        return formattedString;
    }
}
