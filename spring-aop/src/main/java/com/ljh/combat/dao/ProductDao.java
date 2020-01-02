package com.ljh.combat.dao;

import com.ljh.combat.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * ProductDao
 *
 * @author Arsenal
 * created on 2020/1/3 0:20
 */
public interface ProductDao extends JpaRepository<Product, Long> {
    
    public Optional<Product> findById(Long id);
    
}
