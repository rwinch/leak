package pl.pancordev.leak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pancordev.leak.services.*;

@RestController
public class DummyController {

    @Autowired
    private Service1 service1;
    @Autowired
    private Service2 service2;
    @Autowired
    private Service3 service3;
    @Autowired
    private Service4 service4;
    @Autowired
    private Service5 service5;
    @Autowired
    private Service6 service6;
    @Autowired
    private Service7 service7;
    @Autowired
    private Service8 service8;
    @Autowired
    private Service9 service9;
    @Autowired
    private Service10 service10;

    @DeleteMapping("/")
    @PreAuthorize("hasRole('LEAK')")
    public String dummyResponse() {
        return "It's dummy response from server";
    }
}
