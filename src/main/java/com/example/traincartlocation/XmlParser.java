package com.example.traincartlocation;

import java.util.Objects;

public class XmlParser {
    private static String xmlFileName = "";
    public XmlParser (String fileName) {
        xmlFileName = fileName;
    }

    public String[] sectionList() {
        String[] result = {"", ""};
        if (Objects.equals(xmlFileName, "")) {
            result[0] = "A";
        }
        return result;
    }
}
