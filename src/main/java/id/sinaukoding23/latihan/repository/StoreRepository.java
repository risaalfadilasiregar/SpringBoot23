package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.Staffs;
import id.sinaukoding23.latihan.model.Stores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Stores, Integer> {

    List<Stores> findAllByIsDeleted(boolean isDeleted);

}
