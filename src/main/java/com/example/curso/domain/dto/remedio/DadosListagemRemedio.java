package com.example.curso.domain.dto.remedio;

import com.example.curso.domain.enums.Laboratorio;
import com.example.curso.domain.enums.Via;
import com.example.curso.entity.Remedio;

import java.time.LocalDate;

public record DadosListagemRemedio(String nome, Via via, int lote, Laboratorio laboratorio, LocalDate validade) {
    public DadosListagemRemedio(Remedio remedio) {
        this(remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getValidade());
    }
}
