package net.weg.wdm.repository;

import net.weg.wdm.entity.Reserva;
import net.weg.wdm.entity.StatusReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findAllByTurma_IdAndStatusOrderByDiaDesc(Long id, StatusReserva statusReserva);

}
