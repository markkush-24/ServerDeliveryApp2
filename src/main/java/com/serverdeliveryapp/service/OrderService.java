package com.serverdeliveryapp.service;


import com.serverdeliveryapp.entity.ClientOrder;

import java.util.List;

public interface OrderService {
    ClientOrder getOrderById(int id);

    public List<ClientOrder> getAllOrders();

    void saveOrder(ClientOrder clientOrder);
}
