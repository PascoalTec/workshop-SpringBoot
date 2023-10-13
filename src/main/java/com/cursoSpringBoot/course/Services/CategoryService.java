package com.cursoSpringBoot.course.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cursoSpringBoot.course.Entity.CategoryEntity;
import com.cursoSpringBoot.course.Repository.CategoryRepository;


@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;

    public List<CategoryEntity> findAll(){
        return repository.findAll();
    }

    public CategoryEntity findById(Long id) {
        Optional<CategoryEntity> obj =  repository.findById(id);
        return obj.get();
    }
}
