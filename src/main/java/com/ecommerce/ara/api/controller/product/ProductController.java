package com.ecommerce.ara.api.controller.product;

import com.ecommerce.ara.domain.Product;
import com.ecommerce.ara.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<Product> getProducts() {

        return service.getProducts();
    }
}
