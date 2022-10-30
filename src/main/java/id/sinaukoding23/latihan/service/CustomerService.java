package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Customers;
import id.sinaukoding23.latihan.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Transactional(readOnly = true)
    public List<Customers> findAll(){

        List<Customers> data = repository.findAllByIsDeleted(false);

         data.stream().filter( customer -> !customer.isDeleted()).collect(Collectors.toList());

        return data;
    }

    @Transactional
    public Customers createData(Customers param){
        param.setCreatedDate(new Date());
        param.setDeleted(false);
        return repository.save(param);
    }

    @Transactional
    public Customers updateData(Customers param, int id){
        Customers data = repository.findById(id).get();

        if (data != null){
            data.setFirstName(param.getFirstName() != null ? param.getFirstName() : data.getFirstName());
            data.setLastName(param.getLastName() != null ? param.getLastName() : data.getLastName());
            data.setPhone(param.getPhone() != null ? param.getPhone() : data.getPhone());
            data.setEmail(param.getEmail() != null ? param.getEmail() : data.getEmail());
            data.setStreet(param.getStreet() != null ? param.getStreet() : data.getStreet());
            data.setCity(param.getCity() != null ? param.getCity() : data.getCity());
            data.setZipCode(param.getZipCode() != null ? param.getZipCode() : data.getZipCode());
            data.setState(param.getState() != null ? param.getState() : data.getState());
            data.setUpdatedDate(new Date());

            return repository.save(data);
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        Customers data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }

}
