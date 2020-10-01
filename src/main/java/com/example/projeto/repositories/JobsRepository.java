package com.example.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto.entities.Jobs;

public interface JobsRepository extends JpaRepository<Jobs, Long>{

}
