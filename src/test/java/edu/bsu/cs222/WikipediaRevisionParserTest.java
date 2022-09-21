package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

//Example code

public class WikipediaRevisionParserTest {

    @Test
    public void testParseTimestamp() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String timestamp = String.valueOf(parser.parseTimestamp(testDataStream));
        Assertions.assertEquals("2022-09-17T05:54:56Z", timestamp);
    }

    @Test
    public void testParseAuthor() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String author = String.valueOf(parser.parseAuthor(testDataStream));
        Assertions.assertEquals("FMSky", author);
    }
}
