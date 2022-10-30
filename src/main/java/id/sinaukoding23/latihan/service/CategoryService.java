package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Categories;
import id.sinaukoding23.latihan.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<Categories> findAll(){

        List<Categories> data = repository.findAllByIsDeleted(false);

        data.stream().filter(categories -> !categories.isDeleted()).collect(Collectors.toList());

        return data;
    }

    @Transactional
    public Categories createData(Categories param){
        param.setCreatedDate(new Date());
        param.setDeleted(false);
        return repository.save(param);
    }

    @Transactional
    public Categories updateData(Categories param, int id){
        Categories data = repository.findById(id).get();

        if (data != null){
            data.setCategoryName(param.getCategoryName() != null ? param.getCategoryName() : data.getCategoryName());
            data.setUpdatedDate(new Date());

            return repository.save(data);
        }
        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        Categories data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }
        return false;
    }
}
