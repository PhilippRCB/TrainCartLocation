package com.example.traincartlocation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIRequestController {

    @GetMapping("/station/{ril100}/train/{trainNumber}/waggon/{number}")
    public String sectionRequest(@PathVariable int number, @PathVariable String ril100, @PathVariable int trainNumber){
        FileFinder finder = new FileFinder(ril100);
        String fileName = finder.getFileName();
        if (fileName.equals("no File") || fileName.equals("no Match")) return fileName;
        XmlParser parser = new XmlParser(fileName);
        String[] sections = parser.sectionList(trainNumber, number);
        StringBuilder sectionString = new StringBuilder();
        for (String section : sections) sectionString.append("\"%s\",".formatted(section));
        sectionString.deleteCharAt(sectionString.length() - 1);
        return "{ \"sections\": [%s] }".formatted(sectionString);
    }
}
