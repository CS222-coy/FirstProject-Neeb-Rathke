package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Scanner;

//Example code

public class WikipediaRevisionReader {
    public static void main(String[] args) {
        WikipediaRevisionReader revisionReader = new WikipediaRevisionReader();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        try {
            String timestamp = revisionReader.getLastRevisionOf(line);
            System.out.println(timestamp);
        } catch (IOException ioException) {
            System.err.println("network failure" + ioException.getMessage());
        }
    }

    private String getLastRevisionOf(String articleTitle) throws IOException {
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp&rvlimit=1", articleTitle);
        String encodedUrlString = URLEncoder.encode(urlString, Charset.defaultCharset());
        try {
            URL url = new URL(encodedUrlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "janeeb@bsu.edu");
            InputStream inputStream = connection.getInputStream();
            WikipediaRevisionParser parser = new WikipediaRevisionParser();
            String timestamp = parser.parse(inputStream);
            return timestamp;

        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }

    }
}
