package pl.pancordev.leak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service2 {

    @Autowired
    private Service3 service3;

    public String dummyFunction() {
        return "dummy response";
    }
}
