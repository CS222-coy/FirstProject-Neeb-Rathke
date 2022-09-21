package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class GetRevisions {
    public static Revision[] getLastRevisions(String articleTitle) throws IOException {
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp|user&rvlimit=%d", articleTitle, 30);
        String urlStringEncoded = urlString.replaceAll(" ", "%20");
        //System.out.println(urlStringEncoded);

        URL url = new URL(urlStringEncoded);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "janeeb@bsu.edu");
        InputStream inputStream = connection.getInputStream();
        //System.out.println(revisionList[0].getAuthor());
        //System.out.println(revisionList[0].getTimeStamp());
        WikipediaParser wikipediaParser = new WikipediaParser();
        return WikipediaParser.parse(inputStream);


    }
}
