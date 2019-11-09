package com.heorhiireva.salesaccounting.controller;

import com.heorhiireva.salesaccounting.persistence.entity.Supplier;
import com.heorhiireva.salesaccounting.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SupplierController {

    private SupplierService supplierService;

    @RequestMapping(value = "/suppliers")
    public String getSuppliersPage(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("supplierList", supplierService.getAll());

        return "suppliers";
    }

    @RequestMapping(value = "/addSupplier", method = RequestMethod.GET)
    public String getAddBuyerPage(@ModelAttribute("model") ModelMap model) {

        return "addSupplier";
    }

    @RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
    public String addSupplier(@ModelAttribute("supplier") Supplier supplier) {
        supplier.setPhoneNumber("+380" + supplier.getPhoneNumber());

        supplierService.save(supplier);
        return "redirect:/supplier";
    }

    @Autowired
    public void setSupplierService(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
}
