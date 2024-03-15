package com.example.curso.controllers;

import com.example.curso.domain.dto.remedio.DadosCadastroRemedio;
import com.example.curso.domain.dto.remedio.DadosDetalhamentoRemedio;
import com.example.curso.domain.dto.remedio.DadosListagemRemedio;
import com.example.curso.entity.Remedio;
import com.example.curso.repository.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> cadastrar(@Valid @RequestBody DadosCadastroRemedio dados, UriComponentsBuilder uriBUilder) {
        var remedio = new Remedio(dados);
        repository.save(remedio);

        var uri = uriBUilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoRemedio(remedio));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemRemedio>> listar(Pageable paginacao) {
        Page<DadosListagemRemedio> lista = repository.findAllByAtivoTrue(paginacao).map(DadosListagemRemedio::new);
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> atualizar(@Valid @RequestBody DadosCadastroRemedio dados, @PathVariable Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }

//    @DeleteMapping("/{id}")
//    @Transactional
//    public void deletar(@PathVariable Long id) {
//        repository.deleteById(id);
//
//    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> desativar(@PathVariable Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.desativarRemedio();
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> ativar(@PathVariable Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.ativarRemedio();
        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoRemedio> detalhar(@PathVariable Long id) {
        var remedio = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }
}
