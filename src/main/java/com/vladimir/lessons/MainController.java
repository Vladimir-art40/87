package com.vladimir.lessons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("")
public class MainController {

    @GetMapping("/")
    private String main() {
        return "home";
    }

    @GetMapping("/get")
    private @ResponseBody ArrayList<String> get(){
        return DoingsService.doings;
    }

}