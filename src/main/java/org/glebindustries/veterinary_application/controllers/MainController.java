package org.glebindustries.veterinary_application.controllers;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/menu")
    public String getMenu(){
        return "menu";
    }

    @GetMapping("/create-clinic")
    public String getCreateClinic(){
        return "create-clinic";
    }
    @GetMapping("/create-client")
    public String getCreateClient(){
        return "create-client";
    }
    @GetMapping("/create-animal")
    public String getCreateAnimal(){
        return "create-animal";
    }

    @GetMapping("/test")
    public String getTestPage(){
        return "test";
    }

    @PostMapping("/test")
    public String postTest(){
        System.out.println(">>>>>> POST: /test");
        return "redirect:/test";
    }

    @GetMapping("/user")
    public String getUser(Model model, OAuth2AuthenticationToken token){
        String username = token.getName();


        String userGuid =  token.getPrincipal().getAttribute("sub");
        model.addAttribute("username", username);
        model.addAttribute("userGuid", userGuid);

        return "user";
    }
}
