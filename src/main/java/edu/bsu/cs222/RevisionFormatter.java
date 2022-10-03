package edu.bsu.cs222;

public class RevisionFormatter {

    public static String Formatter(Revision[] revisionList, int numberOfRevisions) {

        //Revisions formatted to show each timestamp and the user/author
        String formattedString = "";


        if (revisionList[0].getRedirect() != null) {
            formattedString = revisionList[0].getRedirect();
        }

        for (int i = 0; i < numberOfRevisions; i++) {
           formattedString = formattedString + revisionList[i].getTimeStamp() + " " + revisionList[i].getUser() + "\n";
        }
        return formattedString;
    }
}
