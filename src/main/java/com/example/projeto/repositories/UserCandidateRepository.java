package com.example.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto.entities.UserCandidate;

public interface UserCandidateRepository extends JpaRepository<UserCandidate, Long>{

}
