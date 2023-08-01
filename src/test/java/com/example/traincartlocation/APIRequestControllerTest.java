package com.example.traincartlocation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class APIRequestControllerTest {

    @Test
    void exampleTest() {
        APIRequestController controller = new APIRequestController();
        String reply = controller.sectionRequest(10, "FF", 2310);
        assertEquals("{ \"sections\": [\"B\"] }", reply);
    }

    @Test
    void invalidRilTest(){
        APIRequestController controller = new APIRequestController();
        String reply = controller.sectionRequest(10, "demo", 2310);
        assertEquals("no Match", reply);
    }

    @Test
    void invalidTrain(){
        APIRequestController controller = new APIRequestController();
        String reply = controller.sectionRequest(10, "FF", 1337);
        assertEquals("{ \"sections\": [\"\"] }", reply);
    }

    @Test
    void invalidWaggon(){
        APIRequestController controller = new APIRequestController();
        String reply = controller.sectionRequest(99, "FF", 2310);
        assertEquals("{ \"sections\": [\"\"] }", reply);
    }
}