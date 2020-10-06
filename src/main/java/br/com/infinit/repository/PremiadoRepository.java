package br.com.infinit.repository;

import br.com.infinit.model.Premiado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiadoRepository extends JpaRepository<Premiado, Long> {
}
