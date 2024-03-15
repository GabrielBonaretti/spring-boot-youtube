package com.example.curso.repository;

import com.example.curso.entity.Remedio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {
    Page<Remedio> findAllByAtivoTrue(Pageable paginacao);
}
