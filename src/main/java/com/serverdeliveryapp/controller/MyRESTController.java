package com.serverdeliveryapp.controller;


import com.serverdeliveryapp.entity.ClientOrder;
import com.serverdeliveryapp.service.OrderService;
import com.serverdeliveryapp.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    private final OrderServiceImpl orderService;

    @Autowired
    public MyRESTController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PutMapping ("/clientOrder")
    public ClientOrder addNewOrder(@RequestBody ClientOrder order) {
        orderService.saveOrder(order);
        return order;
    }

    @GetMapping("clientOrder")
    public ClientOrder updateOrders(@RequestParam int id){
     return orderService.getOrderById(id);
    }
}
