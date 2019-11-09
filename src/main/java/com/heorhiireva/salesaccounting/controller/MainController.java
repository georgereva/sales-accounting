package com.heorhiireva.salesaccounting.controller;

import com.heorhiireva.salesaccounting.service.ProductService;
import com.heorhiireva.salesaccounting.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MainController {

    private SaleService saleService;
    private ProductService productService;

    @RequestMapping({"/", "/home"})
    public String getMainPage(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("saleList", saleService.getAll());

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

    @Autowired
    public void setSaleService(SaleService saleService) {
        this.saleService = saleService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
