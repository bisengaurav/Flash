package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
