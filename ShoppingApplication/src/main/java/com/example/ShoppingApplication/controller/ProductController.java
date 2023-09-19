package com.example.ShoppingApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.ShoppingApplication.domain.Product;
import com.example.ShoppingApplication.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	 
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Product> listProduct = service.ListAll();
        model.addAttribute("listProduct", listProduct);
        System.out.print("Get / ");
        return "index";
    }
 
    @GetMapping("/cart")
    public String add(Model model) {
//        model.addAttribute("Product", new Product());
    	List<Product> listProduct = service.ListAll();
        model.addAttribute("listProduct", listProduct);
        return "cart";
    }
    
    @RequestMapping(value="/addtocart", method = RequestMethod.POST)
    public String addToCart(@ModelAttribute("Product") Product product) {
    	service.save(product);
    	return "";
    }
    
    @RequestMapping("/add/{name}/{price}")
    public String addtocart(@PathVariable(name = "name") String name, @PathVariable(name = "price") double price) {
//        System.out.print("HELLOOO\n");
//        System.out.println(price);
        Product product = new Product(name, price);
//        System.out.println("Created\n");

//        System.out.print(product.getProductname());
        service.save(product);
        return "redirect:/cart";  
    }
    	
 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("Product") Product std) {
        service.save(std);
        return "redirect:/";
    }
 
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Product std = service.get(id);
        mav.addObject("Product", std);
        return mav;  
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/cart";
    }
    
    
}
