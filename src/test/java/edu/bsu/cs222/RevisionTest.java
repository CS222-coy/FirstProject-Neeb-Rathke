package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RevisionTest {
    @Test
    public void testRevisionTimestamp(){
        Revision revision = new Revision("Wiki13565", "2022-02-24T07:27:47Z", "The Queen");
        Assertions.assertEquals("2022-02-24T07:27:47Z", revision.getTimeStamp());
    }

    @Test
    public void testRevisionUser(){
        Revision revision = new Revision("Wiki13565", "2022-02-24T07:27:47Z", "The Queen");
        Assertions.assertEquals("Wiki13565", revision.getUser());
    }

    @Test
    public void testRevisionRedirect(){
        Revision revision = new Revision("Wiki13565", "2022-02-24T07:27:47Z", "The Queen");
        Assertions.assertEquals("The Queen", revision.getRedirect());
    }
}
