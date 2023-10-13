package com.cursoSpringBoot.course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cursoSpringBoot.course.Entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    
}
