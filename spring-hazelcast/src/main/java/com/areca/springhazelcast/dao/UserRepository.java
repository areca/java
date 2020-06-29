package com.areca.springhazelcast.dao;

import com.areca.springhazelcast.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(final String username);

    void deleteByUsername(String key);

    @Query("SELECT user.username FROM User user")
    Set<String> findAllUsernames();
}