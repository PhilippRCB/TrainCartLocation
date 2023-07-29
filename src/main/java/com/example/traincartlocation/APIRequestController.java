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
        if (parser.sectionList()[0].isEmpty()) return "Error!";
        if (parser.sectionList()[1].isEmpty()) return "{ \"sections\": [\"%s\"] }".formatted(parser.sectionList()[0]);
        return "{ \"sections\": [\"%s\", \"%s\"] }".formatted(parser.sectionList()[0], parser.sectionList()[1]);
    }
}
