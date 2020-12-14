package pl.pancordev.leak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service10 {

    @Autowired
    private Service1 service1;

    public String dummyFunction() {
        return "dummy response";
    }
}
