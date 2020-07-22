package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CidadeEntity;

public interface CidadeRepository extends JpaRepository<CidadeEntity, Long>{

}
