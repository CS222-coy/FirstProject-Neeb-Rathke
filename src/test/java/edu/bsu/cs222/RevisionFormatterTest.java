package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class RevisionFormatterTest {

    @Test
    public void testRevisionFormatter() throws IOException {
        RevisionFormatter revisionFormatter = new RevisionFormatter();
        Revision revision = new Revision("Wiki13565", "2022-02-24T07:27:47Z");
        Revision[] revisionList = new Revision[1];
        revisionList[0] = revision;
        String outputString = RevisionFormatter.Formatter(revisionList, 1);
        Assertions.assertEquals("2022-02-24T07:27:47Z Wiki13565\n", outputString);
    }
}
