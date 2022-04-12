package ir.openbyte.camel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1", produces = "application/json")
public class TestController {


    @GetMapping("/test")
    public String getEvents() {
        System.out.println("test");
        return "eventList";
    }
}