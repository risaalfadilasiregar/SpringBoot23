package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brands, Integer> {

    List<Brands> findAllByIsDeleted(boolean isDelete);
}
