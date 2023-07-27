package com.example.traincartlocation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIRequestController {

    @GetMapping("/station/{ril100}/train/{trainNumber}/waggon/{number}")
    public String greeting(@PathVariable String number, @PathVariable String ril100, @PathVariable String trainNumber){
        FileFinder finder = new FileFinder(ril100);
        XmlParser parser = new XmlParser(finder.getFileName());
        if (parser.sectionList()[0].isEmpty()) return "Hello World!";
        return "Hello World! from my Spring Boot REST API";
    }
}
