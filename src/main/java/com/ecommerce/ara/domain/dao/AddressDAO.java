package com.ecommerce.ara.domain.dao;

import com.ecommerce.ara.domain.Address;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface AddressDAO extends ListCrudRepository<Address, Long> {

    List<Address> findByUser_Id(Long id);
}
