package com.example.curso.domain.dto.remedio;

import com.example.curso.domain.enums.Laboratorio;
import com.example.curso.domain.enums.Via;

import java.time.LocalDate;

public record DadosCadastroRemedio(
        String nome,
        Via via,
        int lote,
        int quantidade,
        LocalDate validade,
        Laboratorio laboratorio

) {
}
