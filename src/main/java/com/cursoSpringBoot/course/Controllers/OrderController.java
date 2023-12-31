package com.cursoSpringBoot.course.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cursoSpringBoot.course.Entity.OrderEntity;
import com.cursoSpringBoot.course.Services.OrderService;


@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    
    @Autowired
    private OrderService service;


    @GetMapping
    public ResponseEntity<List<OrderEntity>> findAll(){
        List<OrderEntity> list = service.findAll(); 
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderEntity> findById(@PathVariable Long id) {
        OrderEntity obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }
}
