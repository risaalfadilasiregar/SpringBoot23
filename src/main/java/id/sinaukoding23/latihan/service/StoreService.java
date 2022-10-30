package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Stores;
import id.sinaukoding23.latihan.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {

    @Autowired
    private StoreRepository repository;

    @Transactional(readOnly = true)
    public List<Stores> findAll(){

        List<Stores> data = repository.findAllByIsDeleted(false);

        data.stream().filter(stores -> !stores.isDeleted()).collect(Collectors.toList());

        return data;
    }

    @Transactional
    public Stores createData(Stores param){
        param.setCreatedDate(new Date());
        param.setDeleted(false);
        return repository.save(param);
    }

    @Transactional
    public Stores updateData(Stores param, int id){
        Stores data = repository.findById(id).get();

        if (data != null){
            data.setStoreName(param.getStoreName() != null ? param.getStoreName() : data.getStoreName());
            data.setPhone(param.getPhone() != null ? param.getPhone() : data.getPhone());
            data.setEmail(param.getEmail() != null ? param.getEmail() : data.getEmail());
            data.setStreet(param.getStreet() != null ? param.getStreet() : data.getStreet());
            data.setCity(param.getCity() != null ? param.getCity() : data.getCity());
            data.setCity(param.getCity() != null ? param.getCity() : data.getCity());
            data.setState(param.getState() != null ? param.getState() : data.getState());
            data.setZipCode(param.getZipCode() != null ? param.getZipCode() : data.getZipCode());
            data.setUpdatedDate(new Date());

            return repository.save(data);
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        Stores data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }
}
