package edu.bsu.cs222;

import java.io.IOException;
import java.util.Scanner;

//TODO Finish writing tests
//TODO Fix variable names

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        try {
            Revision[] Result = GetRevisions.getLastRevisions(line, 30);
            String output = RevisionFormatter.Formatter(Result, 30);
            System.out.println(output);
        } catch (IOException ioException) {
            System.err.println("network failure" + ioException.getMessage());
        }
    }

}
