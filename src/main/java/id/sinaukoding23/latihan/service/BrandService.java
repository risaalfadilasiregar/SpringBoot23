package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Brands;
import id.sinaukoding23.latihan.model.dto.BrandsDTO;
import id.sinaukoding23.latihan.model.mapper.BrandsMapper;
import id.sinaukoding23.latihan.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository repository;

    @Transactional(readOnly = true)
    public List<BrandsDTO> findAll(){
        List<Brands> data = repository.findAllByIsDeleted(false);

        return BrandsMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public BrandsDTO createData(BrandsDTO param){
        Brands data = BrandsMapper.INSTANCE.dtoToEntity(param);
        data = repository.save(data);

        return BrandsMapper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public BrandsDTO updateData(BrandsDTO param, int id){
        Brands data = repository.findById(id).get();

        if (data != null){
            data.setBrandName(param.getBrandName() != null ? param.getBrandName() : data.getBrandName());
            data.setUpdatedDate(new Date());

            return BrandsMapper.INSTANCE.entityToDto(repository.save(data));
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
