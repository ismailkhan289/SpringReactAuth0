package com.my.spring.toursproj.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    Group findByName(String name);

}
