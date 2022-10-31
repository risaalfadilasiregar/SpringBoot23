package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Categories;
import id.sinaukoding23.latihan.model.dto.CategoriesDTO;
import id.sinaukoding23.latihan.model.mapper.CategoryMapper;
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
    public List<CategoriesDTO> findAll(){

        List<Categories> data = repository.findAllByIsDeleted(false);


        return CategoryMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public CategoriesDTO createData(CategoriesDTO param){
        Categories data = CategoryMapper.INSTANCE.dtoToEntity(param);
        data = repository.save(data);
        return CategoryMapper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public CategoriesDTO updateData(CategoriesDTO param, int id){
        Categories data = repository.findById(id).get();

        if (data != null){
            data.setCategoryName(param.getCategoryName() != null ? param.getCategoryName() : data.getCategoryName());
            data.setUpdatedDate(new Date());

            return CategoryMapper.INSTANCE.entityToDto(repository.save(data));
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
