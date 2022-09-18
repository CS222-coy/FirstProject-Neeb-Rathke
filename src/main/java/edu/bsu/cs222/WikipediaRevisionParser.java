package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class WikipediaRevisionParser {
    public String parse(InputStream testDataStream) throws IOException {
        JSONArray result = (JsonPath.read(testDataStream, "$..timestamp"));
        return result.get(0).toString();
    }
}
