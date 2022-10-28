package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Categories;
import id.sinaukoding23.latihan.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<Categories> findAll(){
        return repository.findAll();
    }
}
