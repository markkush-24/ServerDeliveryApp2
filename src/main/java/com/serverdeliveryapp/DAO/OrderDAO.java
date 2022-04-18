package com.serverdeliveryapp.DAO;



import com.serverdeliveryapp.entity.ClientOrder;

import java.util.List;

public interface OrderDAO {
    ClientOrder getOrderById(int id);

    List<ClientOrder> getAllOrders();

    void saveOrder(ClientOrder clientOrder);

}
