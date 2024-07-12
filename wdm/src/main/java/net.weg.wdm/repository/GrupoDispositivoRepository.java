package net.weg.wdm.repository;

import net.weg.wdm.entity.GrupoDispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoDispositivoRepository extends JpaRepository<GrupoDispositivo, Long> {
}
