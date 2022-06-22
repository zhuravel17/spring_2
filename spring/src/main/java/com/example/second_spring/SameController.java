package com.example.second_spring;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SameController {

    @GetMapping("/")
    public String getHome() {
        return "act";
    }

    @GetMapping("/home")
    public String getSomeText(String q, Integer h) {
        //System.out.println(h);
        if (q != "") {
            return "home";
        } else {
            return "test";
        }
    }

    @PostMapping(value = "/",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public String postHome(@RequestParam Map<String,String> card) {
        if (card != null){
            System.out.println(card.get("card_num"));
            System.out.println(card.get("cvv"));
        }
        return "act";
    }
}
