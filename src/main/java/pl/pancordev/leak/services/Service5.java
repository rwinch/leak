package pl.pancordev.leak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service5 {

    @Autowired
    private Service6 service6;

    public String dummyFunction() {
        return "dummy response";
    }
}
