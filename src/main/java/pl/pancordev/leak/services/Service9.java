package pl.pancordev.leak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service9 {

    @Autowired
    private Service10 service10;

    public String dummyFunction() {
        return "dummy response";
    }
}
