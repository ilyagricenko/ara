package com.ecommerce.ara.service;

import com.ecommerce.ara.domain.LocalUser;
import com.ecommerce.ara.domain.WebOrder;
import com.ecommerce.ara.domain.dao.WebOrderDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {

    private final WebOrderDAO webOrderDAO;

    public List<WebOrder> getOrders(LocalUser user) {

        return webOrderDAO.findByUser(user);
    }
}
