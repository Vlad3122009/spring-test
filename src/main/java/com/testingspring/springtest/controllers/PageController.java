package com.testingspring.springtest.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class PageController {

    //MainPage
    @GetMapping("/main")
    public String mainPage() {
       return "main";
    }

    //RegistrationPage
    @GetMapping("/registration")
    public String registrationPage(@RequestParam(value = "login", required = false) String login, @RequestParam(value = "password", required = false) String password) {
        System.out.println(login + " - " + password);
        return "registration";
    }

    //AuthorizedPage
    @RequestMapping("/authorized")
    public String authorizedPage(@RequestParam(value = "login", required = false) String login, @RequestParam(value =  "password", required = false) String password) {
        System.out.println(login + " - " + password);
        return "authorized";
    }

    //NewFormPage
    @GetMapping("/newform")
    public String newformPage() {
        return "newform";
    }

    //AnswerFormPage
    @GetMapping("/answerform")
    public String answerformPage() {
        return "answerform";
    }

    //ScoreCountPage
    @GetMapping("/scorecount")
    public String scorecountPage() {
        return "scorecount";
    }






}
