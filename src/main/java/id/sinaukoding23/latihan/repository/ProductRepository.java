package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Integer> {
    List<Products> findAllByIsDeleted(boolean isDeleted);

}
