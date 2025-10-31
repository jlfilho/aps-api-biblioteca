package com.livros.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livros.biblioteca.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
