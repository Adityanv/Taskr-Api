package com.Taskr.TaskrApi.repository;

import com.Taskr.TaskrApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findeByEmail(String email);
    boolean existsByEmail(String email);
}
