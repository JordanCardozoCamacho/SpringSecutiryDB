package com.jordan.SpringSecutiryDB.repository;

import com.jordan.SpringSecutiryDB.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
