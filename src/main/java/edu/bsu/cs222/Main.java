package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TODO tell user about redirects
//TODO make a system error if no name is given
//TODO make an error for if there is no wikipedia page
//TODO Finish writing tests
//TODO Fix variable names
//TODO Fix class names so they are standard

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        try {
            GetRevisions getRevisions = new GetRevisions();
            Revision[] Result = GetRevisions.getLastRevisions(line);
            WikipediaRevisionFormatter wikipediaRevisionFormatter = new WikipediaRevisionFormatter();
            WikipediaRevisionFormatter.revisionFormatter(Result);
        } catch (IOException ioException) {
            System.err.println("Network Failure" + ioException.getMessage());
        }
    }

}
