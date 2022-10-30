package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Categories, Integer> {
    List<Categories> findAllByIsDeleted(boolean isDeleted);
}
