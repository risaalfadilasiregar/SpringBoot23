package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Staffs;
import id.sinaukoding23.latihan.model.dto.StaffDTO;
import id.sinaukoding23.latihan.model.mapper.StaffMapper;
import id.sinaukoding23.latihan.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffService {

    @Autowired
    private StaffRepository repository;

    @Transactional(readOnly = true)
    public List<StaffDTO> findAll(){
        List<Staffs> data = repository.findAllByIsDeleted(false);


        return StaffMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public StaffDTO createData(StaffDTO param){
        Staffs data = StaffMapper.INSTANCE.dtoToEntity(param);
        data = repository.save(data);

        return StaffMapper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public StaffDTO updateData(StaffDTO param, int id){
        Staffs data = repository.findById(id).get();

        if(data != null){
            data.setFirstName(param.getFirstName() != null ? param.getFirstName() : data.getFirstName());
            data.setLastName(param.getLastName() != null ? param.getLastName() : data.getLastName());
            data.setEmail(param.getEmail() != null ? param.getEmail() : data.getEmail());
            data.setPhone(param.getPhone() != null ? param.getPhone() : data.getPhone());
            data.setActive(param.getActive() != null ? param.getActive() : data.getActive());
            data.setUpdatedDate(new Date());

            return StaffMapper.INSTANCE.entityToDto(repository.save(data));
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        Staffs data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }
}
