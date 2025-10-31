package com.livros.biblioteca.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NovoLivroDTO {
    private String titulo;
    private int anoPublicacao;
    private String isbn;
    private Long categoriaId;
    private List<Long> autorIds;
}
