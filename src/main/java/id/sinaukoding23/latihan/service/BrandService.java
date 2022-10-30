package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Brands;
import id.sinaukoding23.latihan.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    @Autowired
    private BrandRepository repository;

    @Transactional(readOnly = true)
    public List<Brands> findAll(){
        List<Brands> data = repository.findAllByIsDeleted(false);
        data.stream().filter( brands -> !brands.isDeleted()).collect(Collectors.toList());
        return data;
    }

    @Transactional
    public Brands createData(Brands param){
        param.setCreatedDate(new Date());
        param.setDeleted(false);
        return repository.save(param);
    }

    @Transactional
    public Brands updateData(Brands param, int id){
        Brands data = repository.findById(id).get();

        if (data != null){
            data.setBrandName(param.getBrandName() != null ? param.getBrandName() : data.getBrandName());
            data.setUpdatedDate(new Date());

            return repository.save(data);
        }
        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        Brands data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }
        return false;
    }
}
