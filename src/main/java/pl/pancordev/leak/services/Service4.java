package pl.pancordev.leak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service4 {

    @Autowired
    private Service5 service5;

    public String dummyFunction() {
        return "dummy response";
    }
}
