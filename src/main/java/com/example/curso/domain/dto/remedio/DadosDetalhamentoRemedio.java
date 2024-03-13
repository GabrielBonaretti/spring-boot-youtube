package com.example.curso.domain.dto.remedio;

import com.example.curso.domain.enums.Laboratorio;
import com.example.curso.domain.enums.Via;
import com.example.curso.entity.Remedio;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosDetalhamentoRemedio(
        String nome,
        Via via,
        int lote,
        int quantidade,
        LocalDate validade,
        Laboratorio laboratorio
) {

    public DadosDetalhamentoRemedio(Remedio remedio) {
        this(
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
                remedio.getQuantidade(),
                remedio.getValidade(),
                remedio.getLaboratorio()
        );
    }
}
