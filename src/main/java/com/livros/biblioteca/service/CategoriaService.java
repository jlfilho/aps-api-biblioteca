package com.livros.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livros.biblioteca.model.Categoria;
import com.livros.biblioteca.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }

    // Atualiza uma categoria existente. Retorna Optional vazio se não existir.
    public Optional<Categoria> atualizar(Long id, Categoria categoriaAtualizada) {
        return categoriaRepository.findById(id).map(categoriaExistente -> {
            // Atualiza apenas o campo nome (outros campos podem ser adicionados conforme necessário)
            categoriaExistente.setNome(categoriaAtualizada.getNome());
            return categoriaRepository.save(categoriaExistente);
        });
    }
}
