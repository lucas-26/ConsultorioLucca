package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MedicoEntity;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Long>{

}
