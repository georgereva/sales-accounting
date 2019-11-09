package com.heorhiireva.salesaccounting.controller;

import com.heorhiireva.salesaccounting.persistence.entity.Buyer;
import com.heorhiireva.salesaccounting.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BuyerController {

    private BuyerService buyerService;

    @RequestMapping("/buyers")
    public String getBuyersPage(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("buyerList", buyerService.getAll());

        return "buyers";
    }

    @RequestMapping(value = "/addBuyer", method = RequestMethod.GET)
    public String getAddBuyerPage(@ModelAttribute("model") ModelMap model) {

        return "addBuyer";
    }

    @RequestMapping(value = "/addBuyer", method = RequestMethod.POST)
    public String addBuyer(@ModelAttribute("buyer") Buyer buyer) {
        buyer.setPhoneNumber("+380" + buyer.getPhoneNumber());

        buyerService.save(buyer);
        return "redirect:/suppliers";
    }

    @Autowired
    public void setBuyerService(BuyerService buyerService) {
        this.buyerService = buyerService;
    }
}
