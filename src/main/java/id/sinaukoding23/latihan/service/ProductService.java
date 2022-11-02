package id.sinaukoding.latihan.service;

import id.sinaukoding.latihan.model.Brand;
import id.sinaukoding.latihan.model.Category;
import id.sinaukoding.latihan.model.Product;
import id.sinaukoding.latihan.model.dto.ProductDTO;
import id.sinaukoding.latihan.model.mapper.BrandMapper;
import id.sinaukoding.latihan.model.mapper.CategoryMapper;
import id.sinaukoding.latihan.model.mapper.ProductMapper;
import id.sinaukoding.latihan.repository.BrandRepository;
import id.sinaukoding.latihan.repository.CategoryRepository;
import id.sinaukoding.latihan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> data = repository.findAllByIsDeleted(false);

        return ProductMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public ProductDTO createData(ProductDTO param) {
        Brand brand = BrandMapper.INSTANCE.dtoToEntity(param.getBrand());

        if (param.getBrand() != null) {
            Brand resBrand = null;

            if (brand.getBrandId() != null) {
                resBrand = brandRepository.getById(brand.getBrandId());
            }
            brand.setCreatedDate(resBrand != null ? resBrand.getCreatedDate() : new Date());

            brand = brandRepository.save(brand);
        }

        Category category = CategoryMapper.INSTANCE.dtoToEntity(param.getCategory());

        if (param.getCategory() != null) {
            Category resCategory = null;

            if (category.getCategoryId() != null)
                resCategory = categoryRepository.getById(category.getCategoryId());

            category.setCreatedDate(resCategory != null ? resCategory.getCreatedDate() : new Date());

            category = categoryRepository.save(category);
        }

        Product data = ProductMapper.INSTANCE.dtoToEntity(param);
        data.setBrand(brand);
        data.setCategory(category);
        data.setCreatedDate(new Date());

        data = repository.save(data);

        return ProductMapper.INSTANCE.entityToDto(data);
    }


    @Transactional
    public ProductDTO updateData(ProductDTO param, int id) {
        Product data = repository.findById(id).get();

        if (data != null) {
            data.setProductName(param.getProductName() != null ? param.getProductName() : data.getProductName());
            data.setModelYears(param.getModelYears() != null ? param.getModelYears() : data.getModelYears());
            data.setListPrice(param.getListPrice() != null ? param.getListPrice() : data.getListPrice());
            data.setUpdatedDate(new Date());

            return ProductMapper.INSTANCE.entityToDto(repository.save(data));
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id) {
        Product data = repository.findById(id).get();

        if (data != null) {
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }
}