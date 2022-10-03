package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class RevisionParserTest {

    @Test
    public void testParseTimestamp() throws IOException, CustomException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        Revision[] timestamp = (parser.parse(testDataStream));
        Assertions.assertEquals("2022-09-13T02:55:19Z", timestamp[0].getTimeStamp());
    }

    @Test
    public void testParseFourthTimestamp() throws IOException, CustomException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        Revision[] timestamp = (parser.parse(testDataStream));
        Assertions.assertEquals("2022-09-10T07:27:39Z", timestamp[3].getTimeStamp());
    }

    @Test
    public void testParseUser() throws IOException, CustomException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        Revision[] user = (parser.parse(testDataStream));
        Assertions.assertEquals("Mitch Ames", user[0].getUser());
    }

    @Test
    public void testParseFourthUser() throws IOException, CustomException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        Revision[] user = (parser.parse(testDataStream));
        Assertions.assertEquals("Collinanderson", user[3].getUser());
    }

    @Test
    public void testRedirect() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray titleResult = JsonPath.read(testDataStream,"$..redirects..to");
        Assertions.assertEquals("[\"The Queen\"]", titleResult.toJSONString());
    }
}
