package edu.bsu.cs222;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberOfRevisions = 30;

        Scanner scanner = new Scanner(System.in);
        String usersTitle = scanner.nextLine();
        if (usersTitle.isBlank()) {
            System.err.println("No Title Entered");
            System.exit(1);
        }

        try {
            Revision[] revisionList = GetRevisions.getLastRevisions(usersTitle, numberOfRevisions);
            String formattedRevisions = RevisionFormatter.Formatter(revisionList, numberOfRevisions);
            System.out.println(formattedRevisions);
        } catch (IOException ioException) {
            System.err.println("Network Error" + ioException.getMessage());
            System.exit(3);
        }
    }

}
