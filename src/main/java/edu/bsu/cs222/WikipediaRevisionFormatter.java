package edu.bsu.cs222;

import edu.bsu.cs222.Revision;

public class WikipediaRevisionFormatter {
    public static void revisionFormatter(Revision[] revisionList) {
        for (int i = 0; i < revisionList.length; i++) {
            System.out.print(revisionList[i].getTimeStamp() + " ");
            System.out.print(revisionList[i].getAuthor() + "\n");
        }

    }
}
