package com.example.curso.controllers;

import com.example.curso.domain.dto.remedio.DadosCadastroRemedio;
import com.example.curso.domain.dto.remedio.DadosListagemRemedio;
import com.example.curso.entity.Remedio;
import com.example.curso.repository.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@Valid @RequestBody DadosCadastroRemedio dados) {
        repository.save(new Remedio(dados));
    }

    @GetMapping
    public List<DadosListagemRemedio> listar() {
        return repository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList();
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@Valid @RequestBody DadosCadastroRemedio dados, @PathVariable Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
//        repository.deleteById(id);

        var remedio = repository.getReferenceById(id);
        remedio.deletarRemedio();
    }
}
