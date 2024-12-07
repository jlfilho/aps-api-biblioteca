package com.livros.biblioteca.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livros.biblioteca.dto.CategoriaResumoDTO;
import com.livros.biblioteca.model.Categoria;
import com.livros.biblioteca.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    // Listar todas as categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        List<Categoria> categorias = categoriaService.listar();
        return ResponseEntity.ok(categorias); // Retorna 200 OK
    }

    // Buscar categoria por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        return categoriaService.buscarPorId(id)
                .map(ResponseEntity::ok) // Retorna 200 OK se encontrado
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // Retorna 404 Not Found se não encontrado
    }

    // Criar uma nova categoria
    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria) {
        Categoria novaCategoria = categoriaService.salvar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria); // Retorna 201 Created
    }

    // Atualizar uma categoria existente
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        if (!categoriaService.buscarPorId(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found se a categoria não
                                                                        // existir
        }
        categoria.setCodigo(id);
        Categoria categoriaAtualizada = categoriaService.salvar(categoria);
        return ResponseEntity.ok(categoriaAtualizada); // Retorna 200 OK se atualizado com sucesso
    }

    // Deletar uma categoria por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!categoriaService.buscarPorId(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found se a categoria não
                                                                        // existir
        }
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content se deletado com sucesso
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<CategoriaResumoDTO>> listarCategorias() {
        List<CategoriaResumoDTO> categoriasDTO = categoriaService.listar().stream()
                .map(categoria -> {
                    CategoriaResumoDTO dto = new CategoriaResumoDTO();
                    dto.setCodigo(categoria.getCodigo());
                    dto.setNome(categoria.getNome());
                    dto.setQuantidadeLivros(categoria.getLivros().size());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(categoriasDTO);
    }
}
