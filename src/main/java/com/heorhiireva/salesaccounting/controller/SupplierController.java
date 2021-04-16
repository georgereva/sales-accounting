package com.heorhiireva.salesaccounting.controller;

import com.heorhiireva.salesaccounting.persistence.entity.Supplier;
import com.heorhiireva.salesaccounting.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class SupplierController {

    private SupplierService supplierService;

    @RequestMapping(value = "/suppliers")
    public String getSuppliersPage(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("supplierList", supplierService.getAll());

        return "suppliers";
    }

    @RequestMapping(value = "/addSupplier", method = RequestMethod.GET)
    public String getAddSupplierPage(@ModelAttribute("model") ModelMap model) {
        return "addSupplier";
    }

    @RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
    public String addSupplier(@ModelAttribute("supplier") Supplier supplier) {
        supplier.setPhoneNumber("+380" + supplier.getPhoneNumber());

        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/updateSupplier", method = RequestMethod.GET)
    public String getUpdateSupplier(@RequestParam UUID id, ModelMap model) {
        model.addAttribute("supplier", supplierService.getOne(id));
        return "updateSupplier";
    }

    @RequestMapping(value = "/updateSupplier", method = RequestMethod.POST)
    public String updateSupplier(@ModelAttribute("supplierId") UUID id, Supplier supplier) {
        supplier.setSupplierId(id);
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @Autowired
    public void setSupplierService(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
}
