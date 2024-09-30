package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles request at localhost:8080/hello
    @GetMapping("hello")
    public String hello(){
        return "Hello, Spring!";
    }

    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Handles requests for /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "helloQuery")
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='helloQuery' method='post'>" + //submits requests to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("languageForm")
    public String helloFormLanguage(){
        return "<html>" +
                    "<body>" +
                        "<form action='helloLanguage' method='post'>" + //submits requests to /hello
                            "<input type='text' name='name'>" +
                            "<select name='language' id='language-select'>" +
                                "<option value=''>*Select*</option>" +
                                "<option value='Hola'>Spanish</option>" +
                                "<option value='Bonjour'>French</option>" +
                                "<option value='Hello'>English</option>" +
                                "<option value='Beep Boop'>Robot</option>" +
                                "<option value='Hallo'>German</option>" +
                            "</select>" +
                            "<input type='submit' value='Greet Me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "helloLanguage")
    public String helloLanguageForm(@RequestParam String name, @RequestParam String language){
        return language+ ", " + name + "!";
    }
}
