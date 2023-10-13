package com.cursoSpringBoot.course.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cursoSpringBoot.course.Entity.OrderEntity;
import com.cursoSpringBoot.course.Repository.OrderRepository;


@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repository;

    public List<OrderEntity> findAll(){
        return repository.findAll();
    }

    public OrderEntity findById(Long id) {
        Optional<OrderEntity> obj =  repository.findById(id);
        return obj.get();
    }
}
