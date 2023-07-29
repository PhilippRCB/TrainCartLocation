package com.example.traincartlocation;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileFinderTest {

    @Test
    void getFileName() {
        FileFinder testFinder = new FileFinder("FF");
        assertEquals("FF_2017-12-01_10-47-17.xml", testFinder.getFileName());
    }

    @Test
    void getXmlFile() {
        FileFinder testFinder = new FileFinder("ff");
        File expectedFile = new File("./Data/TrainData/FF_2017-12-01_10-47-17.xml");
        assertEquals(expectedFile, testFinder.getXmlFile());
    }
}