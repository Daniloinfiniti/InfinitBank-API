package br.com.infinit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.infinit.model.PedidoFormaPagamento;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoFormaPagamentoRepository extends JpaRepository<PedidoFormaPagamento, Long> {
}
