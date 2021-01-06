package edu.arf4.motivationbalance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestRestController {

    @GetMapping("/rest")
    public String getHome() {
        return "<h2> WELCOME ON HOMEPAGE</h2>";
    }

    @GetMapping("/rest/dto")
    public String getDto(Principal principal) {
        return "DTO";
    }



}
