package com.example.testingCI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestingCIController {
	@Autowired
    private TestingCI testingCI;

    @RequestMapping("/sum")
    String sum(@RequestParam("a") Integer a, 
               @RequestParam("b") Integer b) {
         return String.valueOf(testingCI.sum(a, b));
    }
}
