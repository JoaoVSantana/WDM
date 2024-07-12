package net.weg.wdm.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.wdm.entity.DiaSemana;

@AllArgsConstructor
@Data
public class PeriodoReservaRequestPostDTO {
    private Long idPeriodo;
    private Long idAmbiente;
    private DiaSemana diaSemana;
}
