package com.heorhiireva.salesaccounting.controller;

import com.heorhiireva.salesaccounting.persistence.entity.Product;
import com.heorhiireva.salesaccounting.persistence.entity.Supplier;
import com.heorhiireva.salesaccounting.service.ProductService;
import com.heorhiireva.salesaccounting.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    private ProductService productService;
    private SupplierService supplierService;

    @RequestMapping("/products")
    public String getProductsPage(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("productList", productService.getAll());

        return "products";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String getAddProductPage(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("supplierList", supplierService.getAll());

        return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduce(@ModelAttribute("product") Product product, @ModelAttribute("supplier") Supplier supplier) {

        product.addSupplier(supplier);
        productService.save(product);

        return "redirect:/products";
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setSupplierService(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
}
