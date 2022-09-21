package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class RevisionParser {
    public static Revision[] parse(InputStream DataStream) throws IOException {
        JSONArray WikiResult = (JsonPath.read(DataStream, "$..*"));
        JSONArray titleResult = JsonPath.read(WikiResult,"$..redirects..to");
        JSONArray timestampResult = JsonPath.read(WikiResult,"$..timestamp");
        JSONArray userResult = JsonPath.read(WikiResult,"$..user");

        if (titleResult.size() > 0) {
            System.out.println("Redirected to " + titleResult.get(0).toString());
        }

        if (userResult.size() > 0) {
            Revision[] revisionList = new Revision[userResult.size()];

            for (int i = 0; i < userResult.size(); i++) {
                Revision revision = new Revision(userResult.get(i).toString(), timestampResult.get(i).toString());
                revisionList[i] = revision;
            } return revisionList;

        } else {
            System.err.println("Failed to find page for given title");
            System.exit(2);
        }

        return null;
    }
}
