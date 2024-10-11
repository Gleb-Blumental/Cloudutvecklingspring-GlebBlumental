package org.glebindustries.veterinary_application.controllers;

import org.glebindustries.veterinary_application.models.Animal;
import org.glebindustries.veterinary_application.service.AnimalService;
import org.glebindustries.veterinary_application.service.ClientService;
import org.glebindustries.veterinary_application.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {

    @GetMapping("/home")
    public String getHomePage() {
        return "home";
    }
    @GetMapping("/menu")
    public String getMenuPage() {
        return "menu"; // This points to templates/menu.html
    }
    @GetMapping("/clinic")
    public String getClientPage() {
        return "client";
    }

    @GetMapping("/clinic")
    public String getClinicPage() {
        return "clinic"; // This points to templates/menu.html
    }
}
