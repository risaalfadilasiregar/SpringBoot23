package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.Stores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Stores, Integer> {
}
