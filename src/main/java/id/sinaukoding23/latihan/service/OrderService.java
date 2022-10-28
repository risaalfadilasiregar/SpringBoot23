package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Orders;
import id.sinaukoding23.latihan.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public List<Orders> findAll(){
        return repository.findAll();
    }
}
