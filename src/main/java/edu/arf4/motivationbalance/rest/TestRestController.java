package edu.arf4.motivationbalance.rest;

import edu.arf4.motivationbalance.dto.EstimationPairDto;
import edu.arf4.motivationbalance.dto.ResultDto;
import edu.arf4.motivationbalance.model.Factor;
import edu.arf4.motivationbalance.model.enums.Estimation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestRestController {

    @GetMapping
    public String getHome() {
        return "<h2> WELCOME ON HOMEPAGE</h2>";
    }

    @GetMapping("/dto")
    public String getDto(Principal principal) {
        return "dto";
    }


}
