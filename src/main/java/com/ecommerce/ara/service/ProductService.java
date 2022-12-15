package com.ecommerce.ara.service;

import com.ecommerce.ara.domain.Product;
import com.ecommerce.ara.domain.dao.ProductDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductDAO productDAO;

    public List<Product> getProducts() {

        return productDAO.findAll();
    }
}
