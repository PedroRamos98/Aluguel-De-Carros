package org.example.alugueldecarros.repository;

import org.example.alugueldecarros.model.PedidoAluguel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoAluguel, Long> {
    List<PedidoAluguel> findByClienteId(Long clienteId);
}
