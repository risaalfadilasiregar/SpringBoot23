package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Products;
import id.sinaukoding23.latihan.model.dto.ProductDTO;
import id.sinaukoding23.latihan.model.mapper.PruductMappper;
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
    public List<ProductDTO> findAll(){

        List<Products> data = repository.findAllByIsDeleted(false);

        return PruductMappper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public ProductDTO createData(ProductDTO param){
        Products data = PruductMappper.INSTANCE.dtoToEntity(param);
        data = repository.save(data);

        return PruductMappper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public ProductDTO updateData(ProductDTO param, int id){
        Products data = repository.findById(id).get();

        if (data != null){
            data.setProductName(param.getProductName() != null ? param.getProductName() : data.getProductName());
            data.setModelYear(param.getModelYear() != null ? param.getModelYear() : data.getModelYear());
            data.setListPrice(param.getListPrice() != null ? param.getListPrice() : data.getListPrice());
            data.setUpdatedDate(new Date());

            return PruductMappper.INSTANCE.entityToDto(repository.save(data));
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
