package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaParser {
    public static Revision[] parse(InputStream DataStream) throws IOException {
        JSONArray WikiResult = (JsonPath.read(DataStream, "$..['timestamp','user']"));
        JSONArray TimestampResult = JsonPath.read(WikiResult,"$..timestamp");
        JSONArray userResult = JsonPath.read(WikiResult,"$..user");
        System.out.println(TimestampResult);
        System.out.println(userResult);

        Revision[] revisionList = new Revision[WikiResult.size()];
        for (int i = 0; i < WikiResult.size(); i++) {
            Revision revision = new Revision(userResult.get(i).toString(), TimestampResult.get(i).toString());
            revisionList[i] = revision;
            System.out.println(revisionList[i].getAuthor());
            System.out.println(revisionList[i].getTimestamp());
        }
        return revisionList;
    }
}
