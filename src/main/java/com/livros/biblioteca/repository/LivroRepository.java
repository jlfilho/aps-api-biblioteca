package com.livros.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livros.biblioteca.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
