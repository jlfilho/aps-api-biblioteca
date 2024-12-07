package com.livros.biblioteca.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorDetalhadoDTO {
    private Long codigo;
    private String nome;
    private String nacionalidade;
    private List<String> titulosLivros;
}
