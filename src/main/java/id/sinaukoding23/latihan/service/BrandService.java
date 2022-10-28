package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Brands;
import id.sinaukoding23.latihan.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository repository;


    public List<Brands> findAll(){
        return repository.findAll();
    }
}
