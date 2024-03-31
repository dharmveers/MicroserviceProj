package com.dharam.user.repositories;

import com.dharam.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String id);
}
