package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @ResponseBody tells a controller that the object returned is automatically serialized into JSON
// and passed back into the HttpResponse object

public class HelloWorldController {

    // HTTP Get Request
    //We use @GetMapping annotation to map HTTP GET request onto specific handler method.
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
