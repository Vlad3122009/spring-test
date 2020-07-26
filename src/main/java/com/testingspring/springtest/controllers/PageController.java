package com.testingspring.springtest.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    //MainPage
    @GetMapping("/main")
    public String mainPage() {
       return "/main";
    }

    //RegistrationPage
    @GetMapping("/registration")
    public String registrationPage() {
        return "/registration";
    }

    //AuthorizedPage
    @GetMapping("/authorized")
    public String authorizedPage() {
        return "/authorized";
    }

    //NewFormPage
    @GetMapping("/newform")
    public String newformPage() {
        return "/newform";
    }

    //AnswerFormPage
    @GetMapping("/answerform")
    public String answerformPage() {
        return "/answerform";
    }

    //ScoreCountPage
    @GetMapping("/scorecount")
    public String scorecountPage() {
        return "/scorecount";
    }






}
