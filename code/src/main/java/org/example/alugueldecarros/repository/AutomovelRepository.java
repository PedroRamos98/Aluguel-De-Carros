package org.example.alugueldecarros.repository;

import org.example.alugueldecarros.model.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovelRepository extends JpaRepository<Automovel, Long> {
}
