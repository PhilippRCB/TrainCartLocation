package com.example.traincartlocation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileFinderTest {

    @Test
    void getFileName() {
        FileFinder testFinder = new FileFinder("FF");
        assertEquals("./Data/TrainData/FF_2017-12-01_10-47-17.xml", testFinder.getFileName());
    }

    @Test
    void invalidRil() {
        FileFinder testFinder = new FileFinder("demo");
        assertEquals("no Match", testFinder.getFileName());
    }
}