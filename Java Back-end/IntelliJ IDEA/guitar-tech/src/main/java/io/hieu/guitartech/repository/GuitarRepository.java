package io.hieu.guitartech.repository;

import io.hieu.guitartech.domain.Guitar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuitarRepository extends JpaRepository<Guitar, Long> {
    @Query(value = "SELECT * FROM guitar WHERE guitar.model LIKE %?%", nativeQuery = true)
    List<Guitar> search(String keyword);
}