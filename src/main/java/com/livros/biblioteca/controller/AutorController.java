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

import com.livros.biblioteca.model.Autor;
import com.livros.biblioteca.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    // Listar todos os autores
    @GetMapping
    public ResponseEntity<List<Autor>> listar() {
        List<Autor> autores = autorService.listar();
        return ResponseEntity.ok(autores); // Retorna 200 OK
    }

    // Buscar autor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable Long id) {
        return autorService.buscarPorId(id)
            .map(ResponseEntity::ok) // Retorna 200 OK se encontrado
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // Retorna 404 Not Found se não encontrado
    }

    // Criar um novo autor
    @PostMapping
    public ResponseEntity<Autor> criar(@RequestBody Autor autor) {
        Autor novoAutor = autorService.salvar(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAutor); // Retorna 201 Created
    }

     // Atualizar um autor existente
     @PutMapping("/{id}")
     public ResponseEntity<Autor> atualizar(@PathVariable Long id, @RequestBody Autor autor) {
         if (!autorService.buscarPorId(id).isPresent()) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found se o autor não existir
         }
         autor.setCodigo(id);
         Autor autorAtualizado = autorService.salvar(autor);
         return ResponseEntity.ok(autorAtualizado); // Retorna 200 OK se atualizado com sucesso
     }

    // Deletar um autor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!autorService.buscarPorId(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found se o autor não existir
        }
        autorService.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content se deletado com sucesso
    }
}
