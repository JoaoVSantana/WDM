package net.weg.wdm.controller.dto.solicitacao;

import net.weg.wdm.controller.dto.periodo.PeriodoResponseDTO;
import net.weg.wdm.entity.Dispositivo;
import net.weg.wdm.entity.Turma;
import net.weg.wdm.entity.Usuario;

import java.time.LocalDate;
import java.util.List;

public record SolicitacaoResponseDTO(
        Usuario Usuario,
        Turma turma,
        List<Dispositivo> idDispositivos,
        List<PeriodoResponseDTO> periodos,
        LocalDate inicio,
        LocalDate fim) {
}
