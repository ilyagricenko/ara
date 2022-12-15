package com.ecommerce.ara.api.controller.order;

import com.ecommerce.ara.domain.LocalUser;
import com.ecommerce.ara.domain.WebOrder;
import com.ecommerce.ara.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<WebOrder> getOrders(@AuthenticationPrincipal LocalUser user) {

        return orderService.getOrders(user);
    }
}
