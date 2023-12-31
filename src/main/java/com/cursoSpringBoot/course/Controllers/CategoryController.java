package com.cursoSpringBoot.course.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cursoSpringBoot.course.Entity.CategoryEntity;
import com.cursoSpringBoot.course.Services.CategoryService;



@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    
    @Autowired
    private CategoryService service;


    @GetMapping
    public ResponseEntity<List<CategoryEntity>> findAll(){
        List<CategoryEntity> list = service.findAll(); 
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryEntity> findById(@PathVariable Long id) {
        CategoryEntity obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }
}
