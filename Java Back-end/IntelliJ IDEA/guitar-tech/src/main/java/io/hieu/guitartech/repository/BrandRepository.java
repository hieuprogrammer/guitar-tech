package io.hieu.guitartech.repository;

import io.hieu.guitartech.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("SELECT brand FROM Brand brand WHERE brand.name LIKE %?1%")
    List<Brand> search(String keyword);
}