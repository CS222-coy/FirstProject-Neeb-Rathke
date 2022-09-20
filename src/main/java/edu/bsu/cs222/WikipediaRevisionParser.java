package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

//Example code
public class WikipediaRevisionParser {
    //WikipediaRevisionParser now returns a revision object
    public Revision parse(InputStream testDataStream) throws IOException {

        JSONArray result = (JsonPath.read(testDataStream, "$..timestamp"));
        Revision revision = new Revision("test", result.get(0).toString());
        return revision;
    }

}
