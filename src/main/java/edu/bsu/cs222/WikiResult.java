package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class WikiResult {
    InputStream DataStream;
    String redirect;

    public WikiResult(InputStream DataStream){
        this.DataStream = DataStream;
    }

    public String getRedirect() throws IOException {
        JSONArray titleResult = JsonPath.read(DataStream,"$..redirects..to");
        if (titleResult.size() > 0) {
            redirect = "Redirected to " + titleResult.get(0).toString();
        }
        return redirect;
    }
}
