package com.testingspring.springtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class SiteController {



    @GetMapping
    public String main(Map<String,Object> model){
        model.put("some", "Всем привет!!! Вперед нас ждут великие дела!");
        return "main";
    }

}