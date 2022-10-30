package id.sinaukoding23.latihan.repository;


import id.sinaukoding23.latihan.model.Staffs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staffs, Integer> {
    List<Staffs> findAllByIsDeleted(boolean isDeleted);

}
