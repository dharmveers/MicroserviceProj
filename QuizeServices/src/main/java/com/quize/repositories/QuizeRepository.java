package com.quize.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quize.entities.Quize;

public interface QuizeRepository extends JpaRepository<Quize, Long>{

}
