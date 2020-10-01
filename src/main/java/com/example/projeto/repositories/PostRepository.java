package com.example.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
