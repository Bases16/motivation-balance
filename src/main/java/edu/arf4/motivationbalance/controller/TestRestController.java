package edu.arf4.motivationbalance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/rest")
public class TestRestController {

    @GetMapping
    public String getHome() {
        return "<h2> WELCOME ON HOMEPAGE</h2>";
    }

    @GetMapping("/user")
    public String userPage(Principal principal) {
        return "USER";
    }

    @GetMapping("/spec")
    public String specPage(Principal principal) {
        return "SPEC";
    }

    @GetMapping("/manager")
    public String managerPage(Principal principal) {
        return "MANAGER";
    }

    @GetMapping("/admin")
    public String adminPage(Principal principal) {
        return "ADMIN";
    }


}
