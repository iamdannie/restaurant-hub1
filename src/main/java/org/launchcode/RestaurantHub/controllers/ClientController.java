package org.launchcode.RestaurantHub.controllers;

import org.launchcode.RestaurantHub.models.Client;
import org.launchcode.RestaurantHub.models.User;
import org.launchcode.RestaurantHub.models.data.ClientRepository;
import org.launchcode.RestaurantHub.models.data.UserRepository;
import org.launchcode.RestaurantHub.models.dto.ClientFormDTO;
import org.launchcode.RestaurantHub.models.dto.LoginFormDTO;
import org.launchcode.RestaurantHub.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

import static org.launchcode.RestaurantHub.controllers.AuthenticationController.*;

//building the class and turn into controller
@Controller
public class ClientController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/client")
    public String displayClientFormDTO(Model model) {
        model.addAttribute(new Client());
        return "client";
    }

    @PostMapping("/client")
    public String processClientFormDTO(@ModelAttribute @Valid ClientFormDTO clientFormDTO,
                                       Errors errors, HttpServletRequest request,
                                       Model model) {
        if (errors.hasErrors()) {
            return "client";
        }


        Client newClient = new Client(clientFormDTO.getClientName(),clientFormDTO.getNameOfRestaurant(),clientFormDTO.getAddress()
        ,clientFormDTO.getPhoneNumber(),clientFormDTO.getNameOfRestaurant(),clientFormDTO.getHoursOfOperation());
        clientRepository.save(newClient);
        return "index";
    }
}