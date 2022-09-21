package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class WikipediaRevisionParser {

    //WikipediaRevisionParser now can parse both a timestamp and an author
    public String parseTimestamp(InputStream testDataStream) throws IOException {
        JSONArray result = (JsonPath.read(testDataStream, "$..timestamp"));
        String timestamp = result.get(0).toString();
        return timestamp;
    }
    public String parseAuthor(InputStream testDataStream) throws IOException {
        JSONArray result = (JsonPath.read(testDataStream, "$..user"));
        String author = result.get(0).toString();
        return author;
    }

}
