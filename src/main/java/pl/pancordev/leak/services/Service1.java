package pl.pancordev.leak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service1 {

    @Autowired
    private Service2 service2;

    public String dummyFunction() {
        return "dummy response";
    }
}
