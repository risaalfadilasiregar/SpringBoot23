package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.Staffs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staffs, Integer> {
}
