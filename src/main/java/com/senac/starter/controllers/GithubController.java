package com.senac.starter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/github")
public class GithubController {

    @GetMapping("/desenvolvedor")
    public String showGitHubPage(){

        return "/gitProfile/personal-github";
    }

}
