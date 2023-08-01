package com.example.traincartlocation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XmlParserTest {

    @Test
    void sectionList() {
        XmlParser parser = new XmlParser("./Data/TrainData/FF_2017-12-01_10-47-17.xml");
        String[] sections = parser.sectionList(2310, 14);
        assertEquals("A", sections[0]);
    }

    @Test
    void wrongWaggon() {
        XmlParser parser = new XmlParser("./Data/TrainData/FF_2017-12-01_10-47-17.xml");
        String[] sections = parser.sectionList(2310, 999);
        assertEquals("", sections[0]);
    }

    @Test
    void emptyFilename() {
        XmlParser parser = new XmlParser("");
        String[] sections = parser.sectionList(2310, 14);
        assertEquals("", sections[0]);
    }

}