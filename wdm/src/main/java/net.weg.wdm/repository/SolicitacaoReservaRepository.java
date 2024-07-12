package net.weg.wdm.repository;

import net.weg.wdm.entity.SolicitacaoReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoReservaRepository extends JpaRepository<SolicitacaoReserva, Long> {
}
