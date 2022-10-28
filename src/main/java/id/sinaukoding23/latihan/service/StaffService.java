package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Staffs;
import id.sinaukoding23.latihan.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository repository;

    @Transactional(readOnly = true)
    public List<Staffs> findAll(){
        return repository.findAll();
    }
}
