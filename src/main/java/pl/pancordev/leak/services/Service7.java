package pl.pancordev.leak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service7 {

    @Autowired
    private Service8 service8;

    public String dummyFunction() {
        return "dummy response";
    }
}
