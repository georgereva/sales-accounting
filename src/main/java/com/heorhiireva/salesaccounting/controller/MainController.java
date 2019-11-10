package com.heorhiireva.salesaccounting.controller;

import com.heorhiireva.salesaccounting.persistence.entity.Buyer;
import com.heorhiireva.salesaccounting.persistence.entity.Personal;
import com.heorhiireva.salesaccounting.persistence.entity.Product;
import com.heorhiireva.salesaccounting.persistence.entity.Sale;
import com.heorhiireva.salesaccounting.service.BuyerService;
import com.heorhiireva.salesaccounting.service.PersonalService;
import com.heorhiireva.salesaccounting.service.ProductService;
import com.heorhiireva.salesaccounting.service.SaleService;
import com.heorhiireva.salesaccounting.wrappers.ProductListWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Controller
public class MainController {

    private SaleService saleService;
    private BuyerService buyerService;
    private PersonalService personalService;
    private ProductService productService;

    @RequestMapping({"/", "/home"})
    public String getMainPage(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("saleList", saleService.getAll());

        return "home";
    }

    @RequestMapping(value = "/addSale", method = RequestMethod.GET)
    public String getAddSalePage(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("buyerList", buyerService.getAll());
        model.addAttribute("personalList", personalService.getAll());
        model.addAttribute("productList", productService.getAll());

        return "addSale";
    }

    @RequestMapping(value = "/addSale", method = RequestMethod.POST)
    public String addBuyer(@ModelAttribute("sale") Sale sale, @ModelAttribute("buyer") Buyer buyer,
                           @ModelAttribute("personal") Personal personal, @ModelAttribute("productsWrapper") ProductListWrapper productsWrapper) {

        sale.setName("Продажа №" + (saleService.count() + 1));
        sale.setDateTime(LocalDateTime.now());
        sale.addBuyer(buyer);
        sale.addPersonal(personal);
        sale.addProducts(productsWrapper.getProducts());

        double sum = 0.0;
        for (Product products : productsWrapper.getProducts()) {
            sum += products.getPrice();
        }

        sale.setSum(sum);
        sale.setQty(productsWrapper.getProducts().size());

        saleService.save(sale);
        return "redirect:/home";
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
    public void setBuyerService(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @Autowired
    public void setPersonalService(PersonalService personalService) {
        this.personalService = personalService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
