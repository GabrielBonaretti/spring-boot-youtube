package com.example.curso.domain.dto.remedio;

import com.example.curso.domain.enums.Laboratorio;
import com.example.curso.domain.enums.Via;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroRemedio(
        @NotBlank
        String nome,
        @Enumerated
        Via via,
        @NotNull
        int lote,
        @NotNull
        int quantidade,
        @NotNull
        @Future
        LocalDate validade,
        @Enumerated
        Laboratorio laboratorio
) {
}
