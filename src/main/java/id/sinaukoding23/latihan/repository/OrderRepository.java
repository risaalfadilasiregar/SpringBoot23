package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findAllByIsDeleted(boolean isDeleted);

}
