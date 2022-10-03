package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class GetRevisions {
    public static Revision[] getLastRevisions(String articleTitle, int numberOfRevisions) throws IOException, CustomException {
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp|user&rvlimit=%d&redirects", articleTitle, numberOfRevisions);
        //Takes the spaces in the url and changes it to %20 (encoded version of space)
        String urlStringEncoded = urlString.replaceAll(" ", "%20");

        URL url = new URL(urlStringEncoded);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "janeeb@bsu.edu");
        InputStream inputStream = connection.getInputStream();
        return RevisionParser.parse(inputStream);
    }
}
