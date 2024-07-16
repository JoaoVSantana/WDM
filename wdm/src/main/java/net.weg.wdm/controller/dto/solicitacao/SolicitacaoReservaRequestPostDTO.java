package net.weg.wdm.controller.dto.solicitacao;

import net.weg.wdm.controller.dto.periodo.PeriodoReservaRequestPostDTO;

import java.time.LocalDate;
import java.util.List;

public record SolicitacaoReservaRequestPostDTO(
        Long idUsuario,
        Long idTurma,
        List<Long>idDispositivos,
        List<PeriodoReservaRequestPostDTO> periodos,
        LocalDate inicio,
        LocalDate fim) {
}
