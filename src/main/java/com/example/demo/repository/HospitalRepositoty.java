package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.HospitalEntity;

public interface HospitalRepositoty extends JpaRepository<HospitalEntity, Long>{

}
