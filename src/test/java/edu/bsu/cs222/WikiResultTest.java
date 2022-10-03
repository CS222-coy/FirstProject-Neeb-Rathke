package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class WikiResultTest {
    @Test
    public void testWikiResultRedirect() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        WikiResult wikiResult = new WikiResult(testDataStream);
        Assertions.assertEquals("Redirected to The Queen", wikiResult.getRedirect());
    }
}
