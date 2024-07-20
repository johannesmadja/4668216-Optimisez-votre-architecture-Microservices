package com.clientui.clientui.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clientui.clientui.beans.ProductBean;
import com.clientui.clientui.proxies.MicroserviceProductProxy;

@Controller
public class ClientController {

    private MicroserviceProductProxy microserviceProductProxy;

    public ClientController(MicroserviceProductProxy microserviceProductProxy) {
        this.microserviceProductProxy = microserviceProductProxy;
    }
    
    @RequestMapping("/")
    public String Accueil(Model model) {
        List<ProductBean> products = microserviceProductProxy.retrieveAllProducts();
        model.addAttribute("products", products);

        return "Accueil";
    }
}
