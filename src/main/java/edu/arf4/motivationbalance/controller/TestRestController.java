package edu.arf4.motivationbalance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestRestController {

    @GetMapping
    public String getHome() {
        return "<h2> WELCOME ON HOMEPAGE</h2>";
    }

    @GetMapping("/user")
    public String userPage(Principal principal) {
        String p = principal != null ? principal.getName() +" "+ principal.toString() : "null";
        return "USER: " + p;
    }

    @GetMapping("/spec")
    public String specPage() {
        return "SPEC";
    }

    @GetMapping("/manager")
    public String managerPage() {
        return "MANAGER";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "ADMIN";
    }


}
