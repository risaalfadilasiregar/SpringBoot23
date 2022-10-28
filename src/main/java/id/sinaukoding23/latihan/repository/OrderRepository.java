package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
