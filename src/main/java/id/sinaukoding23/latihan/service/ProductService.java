package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Products;
import id.sinaukoding23.latihan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<Products> findAll(){

        List<Products> data = repository.findAllByIsDeleted(false);

        data.stream().filter(products -> !products.isDeleted()).collect(Collectors.toList());

        return data;
    }

    @Transactional
    public Products createData(Products param){
        param.setCreatedDate(new Date());
        param.setDeleted(false);
        return repository.save(param);
    }

    @Transactional
    public Products updateData(Products param, int id){
        Products data = repository.findById(id).get();

        if (data != null){
            data.setProductName(param.getProductName() != null ? param.getProductName() : data.getProductName());
            data.setModelYear(param.getModelYear() != null ? param.getModelYear() : data.getModelYear());
            data.setListPrice(param.getListPrice() != null ? param.getListPrice() : data.getListPrice());
            data.setUpdatedDate(new Date());

            return repository.save(data);
        }

        return  null;
    }

    @Transactional
    public boolean deleteData(int id){
        Products data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;

    }

}
