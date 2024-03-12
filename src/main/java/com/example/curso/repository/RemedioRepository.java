package com.example.curso.repository;

import com.example.curso.entity.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {
    List<Remedio> findAllByAtivoTrue();
}
