package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class WikipediaRevisionParser {

    //ArrayList<Revision> listOfRevisions = new ArrayList<>();

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

    //TODO: WikipediaRevisionParser currently returns a string but needs to return a revision object
    public String parse(InputStream testDataStream) throws IOException {
        JSONArray jsonRevisions = JsonPath.read(testDataStream, "$..['user', 'timestamp']");

        //TODO: Need to create for loop to create separate revisions and put them in an arraylist

        return jsonRevisions.toJSONString();
    }
}
