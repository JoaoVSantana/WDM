package net.weg.wdm.controller.dto;

import jakarta.persistence.*;
import net.weg.wdm.entity.*;

import java.time.LocalDate;
import java.util.List;

public record ReservaResponseDTO(
        String status,
        Long numero,
        List<DispositivoReservado> dispositivoReservados,
        Ambiente ambiente,
        Turma turma,
        Periodo periodo,
        LocalDate dia,
        String comentario) {
}
