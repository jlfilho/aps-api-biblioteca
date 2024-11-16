package com.livros.biblioteca.controller;

import java.util.List;

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

import com.livros.biblioteca.model.Livro;
import com.livros.biblioteca.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    // Listar todos os livros
    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> livros = livroService.listar();
        return ResponseEntity.ok(livros); // Retorna 200 OK
    }

    // Buscar livro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        return livroService.buscarPorId(id)
            .map(ResponseEntity::ok) // Retorna 200 OK se encontrado
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // Retorna 404 Not Found se não encontrado
    }

    // Criar um novo livro
    @PostMapping
    public ResponseEntity<Livro> criar(@RequestBody Livro livro) {
        Livro novoLivro = livroService.salvar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro); // Retorna 201 Created
    }

    // Atualizar um livro existente
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        if (!livroService.buscarPorId(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found se o livro não existir
        }
        livro.setCodigo(id);
        Livro livroAtualizado = livroService.salvar(livro);
        return ResponseEntity.ok(livroAtualizado); // Retorna 200 OK se atualizado com sucesso
    }

    // Deletar um livro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!livroService.buscarPorId(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found se o livro não existir
        }
        livroService.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content se deletado com sucesso
    }
}
