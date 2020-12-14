package pl.pancordev.leak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service6 {

    @Autowired
    private Service7 service7;

    public String dummyFunction() {
        return "dummy response";
    }
}
