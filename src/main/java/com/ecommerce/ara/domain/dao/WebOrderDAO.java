package com.ecommerce.ara.domain.dao;

import com.ecommerce.ara.domain.LocalUser;
import com.ecommerce.ara.domain.WebOrder;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface WebOrderDAO extends ListCrudRepository<WebOrder, Long> {

    List<WebOrder> findByUser(LocalUser user);
}
