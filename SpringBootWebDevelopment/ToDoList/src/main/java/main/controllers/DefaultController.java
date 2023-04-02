package main.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DefaultController {
    public String init() {
        return (new Date()).toString();
    }
}
