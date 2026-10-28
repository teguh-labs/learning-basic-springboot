package com.teguh.latihan_springboot.repository;

import com.teguh.latihan_springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Dengan extends JpaRepository, lu langsung dapet method bawaan:
    // .save(), .findAll(), .findById(), .deleteById(), dll tanpa nulis query SQL!
}
