package com.huaclinic.restfulapi.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.huaclinic.restfulapi.models.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {
    Optional<Users> findByUsername(String username); 
}
