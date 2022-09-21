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

    @Test
    public void testParse() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String revisions = String.valueOf(parser.parse(testDataStream));
        Assertions.assertEquals("[{\"user\":\"FMSky\",\"timestamp\":\"2022-09-17T05:54:56Z\"}," +
                "{\"user\":\"192.184.216.221\",\"timestamp\":\"2022-09-14T17:02:31Z\"}," +
                "{\"user\":\"98.246.93.219\",\"timestamp\":\"2022-09-13T21:39:57Z\"}," +
                "{\"user\":\"75.172.206.240\",\"timestamp\":\"2022-09-13T01:37:51Z\"}]", revisions);
    }
}
