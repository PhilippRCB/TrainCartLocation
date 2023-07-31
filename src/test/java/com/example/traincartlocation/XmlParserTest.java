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
}