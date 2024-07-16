package net.weg.wdm.controller.dto.solicitacao;

import jakarta.persistence.*;
import net.weg.wdm.controller.dto.ReservaResponseDTO;
import net.weg.wdm.entity.Reserva;

import java.util.List;

public record SolicitacaoReservaResponseDTO(
        Long id,
        List<ReservaResponseDTO> reservas) {
}
