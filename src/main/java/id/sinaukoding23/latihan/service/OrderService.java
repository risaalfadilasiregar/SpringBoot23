package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Orders;
import id.sinaukoding23.latihan.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public List<Orders> findAll(){

        List<Orders> data = repository.findAllByIsDeleted(false);

        data.stream().filter(orders -> !orders.isDeleted()).collect(Collectors.toList());

        return data;
    }

    @Transactional
    public Orders createData(Orders param){
        param.setCreatedDate(new Date());
        param.setDeleted(false);

        return repository.save(param);
    }

    @Transactional
    public Orders updateData(Orders param, int id){
        Orders data = repository.findById(id).get();

        if (data != null){
            data.setOrderDate(param.getOrderDate() != null ? param.getOrderDate() : data.getOrderDate());
            data.setOrderStatus(param.getOrderStatus() != null ? param.getOrderStatus() : data.getOrderStatus());
            data.setRequiredDate(param.getRequiredDate() != null ? param.getRequiredDate() : data.getRequiredDate());
            data.setShippedDate(param.getShippedDate() != null ? param.getShippedDate() : data.getShippedDate());
            data.setUpdatedDate(new Date());

            return repository.save(data);
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        Orders data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }
}
