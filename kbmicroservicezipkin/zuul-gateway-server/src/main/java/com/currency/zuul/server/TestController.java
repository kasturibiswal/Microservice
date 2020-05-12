package com.currency.zuul.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping(path = "/hello")
    public String display() {
        return "Hello Kasturi";
    }

}
