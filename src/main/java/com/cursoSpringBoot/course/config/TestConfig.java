package com.cursoSpringBoot.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursoSpringBoot.course.Entity.OrderEntity;
import com.cursoSpringBoot.course.Entity.UserEntity;
import com.cursoSpringBoot.course.Enums.OrderEnums;
import com.cursoSpringBoot.course.Repository.OrderRepository;
import com.cursoSpringBoot.course.Repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        UserEntity u1 = new UserEntity(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        UserEntity u2 = new UserEntity(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        OrderEntity o1 = new OrderEntity(null, Instant.parse("2019-06-20T19:53:07Z"), OrderEnums.PAID, u1);
        OrderEntity o2 = new OrderEntity(null, Instant.parse("2019-07-21T03:42:10Z"), OrderEnums.WAITING_PAYMENT, u2);
        OrderEntity o3 = new OrderEntity(null, Instant.parse("2019-07-22T15:21:22Z"), OrderEnums.WAITING_PAYMENT, u1);


        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }

}
