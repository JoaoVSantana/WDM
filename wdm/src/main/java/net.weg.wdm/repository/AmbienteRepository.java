package net.weg.wdm.repository;

import net.weg.wdm.entity.Ambiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbienteRepository extends JpaRepository< Ambiente, Long> {
}
