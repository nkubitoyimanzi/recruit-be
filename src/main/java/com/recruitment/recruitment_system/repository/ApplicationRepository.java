package com.recruitment.recruitment_system.repository;

import com.recruitment.recruitment_system.model.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {


    List<Application> findByEmail(String email);


    Page<Application> findByLastNameContainingIgnoreCase(String lastName, Pageable pageable);


    long countByStatus(String status);
}