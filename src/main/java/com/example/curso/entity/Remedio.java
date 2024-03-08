package com.example.curso.entity;

import com.example.curso.domain.dto.remedio.DadosCadastroRemedio;
import com.example.curso.domain.enums.Laboratorio;
import com.example.curso.domain.enums.Via;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "remedio")
@Entity(name = "remedio")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Via via;
    private int lote;
    private int quantidade;
    private LocalDate validade;
    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;

    public Remedio(DadosCadastroRemedio dados) {
        this.nome = dados.nome();
        this.via = dados.via();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();
    }

    public void atualizarInformacoes(DadosCadastroRemedio dados) {
        this.nome = dados.nome();
        this.via = dados.via();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();

    }
}
