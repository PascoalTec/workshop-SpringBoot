package com.cursoSpringBoot.course.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cursoSpringBoot.course.Entity.ProductEntity;
import com.cursoSpringBoot.course.Services.ProductService;


@RestController
@RequestMapping(value = "/products")
public class ProductController {
    
    @Autowired
    private ProductService service;


    @GetMapping
    public ResponseEntity<List<ProductEntity>> findAll(){
        List<ProductEntity> list = service.findAll(); 
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductEntity> findById(@PathVariable Long id) {
        ProductEntity obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }
}
