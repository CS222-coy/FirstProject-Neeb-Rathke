package edu.bsu.cs222;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberOfRevisions = 30;

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.isBlank()) {
            System.err.println("No title entered");
            System.exit(1);
        }

        try {
            Revision[] Result = GetRevisions.getLastRevisions(line, numberOfRevisions);
            String output = RevisionFormatter.Formatter(Result, numberOfRevisions);
            System.out.println(output);
        } catch (IOException ioException) {
            System.err.println("network error" + ioException.getMessage());
            System.exit(3);
        }
    }

}
