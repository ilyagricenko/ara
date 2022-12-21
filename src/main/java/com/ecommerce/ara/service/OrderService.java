package com.ecommerce.ara.service;

import com.ecommerce.ara.domain.LocalUser;
import com.ecommerce.ara.domain.WebOrder;
import com.ecommerce.ara.domain.dao.WebOrderDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private WebOrderDAO webOrderDAO;

    public OrderService(WebOrderDAO webOrderDAO) {
        this.webOrderDAO = webOrderDAO;
    }

    public List<WebOrder> getOrders(LocalUser user) {

        return webOrderDAO.findByUser(user);
    }
}
