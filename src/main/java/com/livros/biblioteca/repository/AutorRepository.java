package com.livros.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livros.biblioteca.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
