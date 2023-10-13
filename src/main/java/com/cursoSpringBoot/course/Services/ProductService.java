package com.cursoSpringBoot.course.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cursoSpringBoot.course.Entity.ProductEntity;
import com.cursoSpringBoot.course.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

        public List<ProductEntity> findAll(){
        return repository.findAll();
    }

    public ProductEntity findById(Long id) {
        Optional<ProductEntity> obj =  repository.findById(id);
        return obj.get();
    }
    
}
