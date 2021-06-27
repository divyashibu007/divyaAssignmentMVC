package com.mvc.controllers;

import com.mvc.model.Product;
import com.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/product_list")
    public String viewProductsHomePage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

        return "product_list";
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = service.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/new_product")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }


    @PostMapping("/save_product")
    public String add(Product product) {
        service.save(product);
        return "product_create_success";
    }

    @RequestMapping("/edit_product/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }


    @PostMapping("/process_edit_product")
    public String updateProduct(@ModelAttribute("product") Product productUpdates) {
        Product existProduct = service.get(productUpdates.getId());
        existProduct.setName(productUpdates.getName());
        existProduct.setPrice(productUpdates.getPrice());

        service.save(existProduct);

        return "edit_success";
    }


   @RequestMapping("/delete_product/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/product_list";
    } 
   
   
    
    
    
}