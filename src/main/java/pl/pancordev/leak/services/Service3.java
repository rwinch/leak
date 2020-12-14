package pl.pancordev.leak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service3 {

    @Autowired
    private Service4 service4;

    public String dummyFunction() {
        return "dummy response";
    }
}
