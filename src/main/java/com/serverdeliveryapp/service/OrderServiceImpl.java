package com.serverdeliveryapp.service;


import com.serverdeliveryapp.DAO.OrderDAO;
import com.serverdeliveryapp.entity.ClientOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;


    @Override
    public ClientOrder getOrderById(int id) {
        return orderDAO.getOrderById(id);
    }

    @Override
    @Transactional
    public List<ClientOrder> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    @Transactional
    public void saveOrder(ClientOrder clientOrder) {
        orderDAO.saveOrder(clientOrder);
    }
}
