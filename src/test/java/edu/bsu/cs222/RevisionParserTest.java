package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class RevisionParserTest {

    @Test
    public void testParseTimestamp() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        Revision[] timestamp = (parser.parse(testDataStream));
        Assertions.assertEquals("2022-09-13T02:55:19Z", timestamp[0].getTimeStamp());
    }

    @Test
    public void testParseUser() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        Revision[] user = (parser.parse(testDataStream));
        Assertions.assertEquals("2022-09-13T02:55:19Z", user[0].getTimeStamp());
    }
}
