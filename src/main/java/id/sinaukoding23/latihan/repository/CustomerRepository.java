package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers, Integer> {
}
