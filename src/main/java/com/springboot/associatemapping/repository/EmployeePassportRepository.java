package com.springboot.associatemapping.repository;

import com.springboot.associatemapping.entity.EmployeePassport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePassportRepository extends JpaRepository<EmployeePassport,Integer> {
}
