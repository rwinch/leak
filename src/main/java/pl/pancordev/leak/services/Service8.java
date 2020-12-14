package pl.pancordev.leak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service8 {

    @Autowired
    private Service9 service9;

    public String dummyFunction() {
        return "dummy response";
    }
}
