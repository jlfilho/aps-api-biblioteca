package com.livros.biblioteca.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LivroDTO {
    private Long codigo;
    private String titulo;
    private String isbn;
    private String categoria;
    List<String> autores;
}