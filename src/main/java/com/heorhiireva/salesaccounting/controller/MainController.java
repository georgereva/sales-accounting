package com.heorhiireva.salesaccounting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class MainController {
    @RequestMapping("/")
    public String getMainPage() {
        return "home";
    }

    @RequestMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout",  logout != null);
        return "login";
    }

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println(dateTime);
    }
}
