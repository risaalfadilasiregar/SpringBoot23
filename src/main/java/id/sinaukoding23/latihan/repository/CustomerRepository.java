package id.sinaukoding23.latihan.repository;


import id.sinaukoding23.latihan.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customers, Integer> {
    List<Customers> findAllByIsDeleted(boolean isDeleted);

}
