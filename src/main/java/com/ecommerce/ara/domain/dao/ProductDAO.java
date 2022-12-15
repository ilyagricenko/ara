package com.ecommerce.ara.domain.dao;

import com.ecommerce.ara.domain.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductDAO extends ListCrudRepository<Product, Long> {
}
