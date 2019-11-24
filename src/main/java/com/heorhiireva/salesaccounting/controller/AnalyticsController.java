package com.heorhiireva.salesaccounting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnalyticsController {

    @RequestMapping("/analytics")
    public String getBuyersPage(@ModelAttribute("model") ModelMap model) {
      //  model.addAttribute("buyerList", buyerService.getAll());

        return "analytics";
    }

}
