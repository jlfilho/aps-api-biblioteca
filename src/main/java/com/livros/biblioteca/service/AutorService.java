package com.livros.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livros.biblioteca.model.Autor;
import com.livros.biblioteca.repository.AutorRepository;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listar() {
        return autorRepository.findAll();
    }

    public Optional<Autor> buscarPorId(Long id) {
        return autorRepository.findById(id);
    }

    public List<Autor> buscarPorIds(List<Long> ids) {
        return autorRepository.findAllById(ids);
    }

    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    public void deletar(Long id) {
        autorRepository.deleteById(id);
    }
}
