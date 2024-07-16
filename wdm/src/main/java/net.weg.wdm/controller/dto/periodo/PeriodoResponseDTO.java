package net.weg.wdm.controller.dto.periodo;

import net.weg.wdm.entity.Ambiente;
import net.weg.wdm.entity.Periodo;

public record PeriodoResponseDTO(
        Periodo periodo,
        Ambiente ambiente,
        String diaSemana) {
}
