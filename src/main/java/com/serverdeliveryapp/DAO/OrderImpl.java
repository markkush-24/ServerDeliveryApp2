package com.serverdeliveryapp.DAO;


import com.serverdeliveryapp.entity.ClientOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class OrderImpl implements OrderDAO {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public ClientOrder getOrderById(int id) {
        Session session = sessionFactory.getCurrentSession();
        ClientOrder clientOrder = session.get(ClientOrder.class, id);
        if(clientOrder.getStatus().equals("created")){
            clientOrder.setStatus("in_preparation");
        }else if(clientOrder.getStatus().equals("in_preparation")){
            clientOrder.setStatus("prepared");
        }else if(clientOrder.getStatus().equals("prepared")){
            clientOrder.setStatus("in_delivery");
        }else if(clientOrder.getStatus().equals("in_delivery")){
            clientOrder.setStatus("delivered");
        }
        return clientOrder;
    }

    @Override
    public List<ClientOrder> getAllOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query<ClientOrder> query = session.createQuery("from ClientOrder", ClientOrder.class);
        List<ClientOrder> clientOrder = query.getResultList();
        return clientOrder;
    }

    @Override
    public void saveOrder(ClientOrder clientOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(clientOrder);
    }
}
