package edu.bsu.cs222;

public class RevisionFormatter {

    public static String Formatter(Revision[] revisionList, int numberOfRevisions) {
        String outputString = "";

        for (int i = 0; i < numberOfRevisions; i++) {
           outputString = outputString + revisionList[i].getTimeStamp() + " " + revisionList[i].getUser() + "\n";
        }
        return outputString;
    }
}
