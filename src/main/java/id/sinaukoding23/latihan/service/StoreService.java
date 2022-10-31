package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Stores;
import id.sinaukoding23.latihan.model.dto.StoreDTO;
import id.sinaukoding23.latihan.model.mapper.StoreMapper;
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
    public List<StoreDTO> findAll(){

        List<Stores> data = repository.findAllByIsDeleted(false);

        return StoreMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public StoreDTO createData(StoreDTO param){
        Stores data = StoreMapper.INSTANCE.dtoToEntity(param);
        data = repository.save(data);

        return StoreMapper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public StoreDTO updateData(StoreDTO param, int id){
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

            return StoreMapper.INSTANCE.entityToDto(repository.save(data));
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
