package com.ecommerce.ara.service;

import com.ecommerce.ara.domain.Product;
import com.ecommerce.ara.domain.dao.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getProducts() {

        return productDAO.findAll();
    }
}
