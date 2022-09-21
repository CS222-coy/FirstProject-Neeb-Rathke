package edu.bsu.cs222;

public class RevisionFormatter {
    //public static void Formatter(Revision[] revisionList) {
    //    for (int i = 0; i < revisionList.length; i++) {
    //        System.out.print(revisionList[i].getTimeStamp() + " ");
    //        System.out.print(revisionList[i].getAuthor() + "\n");
    //    }
    //}

    public static String Formatter(Revision[] revisionList) {
        String outputString = "";
        for (int i = 0; i < revisionList.length; i++) {
           outputString = outputString + revisionList[i].getTimeStamp() + " " + revisionList[i].getUser() + "\n";
        }
        return outputString;
    }
}
