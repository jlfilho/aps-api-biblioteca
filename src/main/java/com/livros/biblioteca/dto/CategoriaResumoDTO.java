package com.livros.biblioteca.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoriaResumoDTO {
    private Long codigo;
    private String nome;
    private int quantidadeLivros;
}
