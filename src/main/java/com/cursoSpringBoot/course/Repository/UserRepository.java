package com.cursoSpringBoot.course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cursoSpringBoot.course.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
