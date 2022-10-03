package edu.bsu.cs222;

import java.io.IOException;
import java.util.Scanner;

//TODO move error handling to main, create custom exception and catch it in main
//TODO move outputs to main
//TODO create MainGUI that handles the gui

public class Main {
    public static void main(String[] args) {
        int numberOfRevisions = 30;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter in the name of a Wikipedia article: ");
        String usersTitle = scanner.nextLine();

        //Exit with error 1 if no title is entered
        try {
            if (usersTitle.isBlank()) {
                throw new CustomException("No Title Entered ");
            }
        } catch (CustomException e) {
            System.out.println(e);
            System.exit(1);
        }

        //Try to run the program, but catch a network error
        try {
            Revision[] revisionList = GetRevisions.getLastRevisions(usersTitle, numberOfRevisions);
            String formattedRevisions = RevisionFormatter.formatter(revisionList, numberOfRevisions);
            System.out.println(formattedRevisions);
        } catch (IOException ioException) {
            System.err.println("Network Error " + ioException.getMessage());
            System.exit(3);
        } catch (CustomException e) {
            System.out.println(e);
            System.exit(2);
        }
    }

}
