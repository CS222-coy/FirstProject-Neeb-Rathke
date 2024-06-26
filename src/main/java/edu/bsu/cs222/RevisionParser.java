package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class RevisionParser {
    public static Revision[] parse(InputStream DataStream) throws IOException, CustomException {
        //General parsing of the information
        JSONArray WikiResult = (JsonPath.read(DataStream, "$..*"));
        JSONArray titleResult = JsonPath.read(WikiResult,"$..redirects..to");
        JSONArray timestampResult = JsonPath.read(WikiResult,"$..timestamp");
        JSONArray userResult = JsonPath.read(WikiResult,"$..user");


        //Throws the revisions into a list
        if (userResult.size() > 0) {
            String redirect = "hello";

            if (titleResult.size() > 0) {
                redirect = "Redirected to " + titleResult.get(0).toString() + "\n" + "\n";
            }

            Revision[] revisionList = new Revision[userResult.size()];
            for (int i = 0; i < userResult.size(); i++) {
                Revision revision = new Revision(userResult.get(i).toString(), timestampResult.get(i).toString(), redirect);
                revisionList[i] = revision;
            } return revisionList;

        //If no page is found, exit with error 2
        } else {
            throw new CustomException("Failed to find page for given title. ");
        }
    }
}
