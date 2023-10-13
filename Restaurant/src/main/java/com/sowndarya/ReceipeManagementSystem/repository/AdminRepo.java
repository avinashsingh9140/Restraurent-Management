package com.sowndarya.ReceipeManagementSystem.repository;

import com.sowndarya.ReceipeManagementSystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {
}
