package br.com.infinit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.infinit.model.PedidoItem;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
}
