package net.weg.wdm.service;

import lombok.AllArgsConstructor;
import net.weg.wdm.controller.dto.PeriodoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.ReservaRequestPostDTO;
import net.weg.wdm.entity.*;
import net.weg.wdm.repository.SolicitacaoReservaRepository;
import net.weg.wdm.service.interfaces.DispositivoServiceInt;
import net.weg.wdm.service.interfaces.SolicitacaoReservaServiceInt;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SolicitacaoReservaServiceImpl implements SolicitacaoReservaServiceInt {

    //Se ta cascade busca as informaçoes do banco antes de fazer um put ou patch

    private final DispositivoServiceImpl dispositivoService;
    private  final SolicitacaoReservaRepository repository;
    @Override
    public SolicitacaoReserva criarSolicitacaoReserva(ReservaRequestPostDTO reservaDTO) {

        SolicitacaoReserva solicitacaoReserva = new SolicitacaoReserva();
        repository.save(solicitacaoReserva);
        Map<TipoDispositivo, List<Dispositivo>> dispositivos = dispositivoService.buscarDispositivosPorIdSeparadosPorTipo
                (reservaDTO.getIdDispositivos());
        Set<TipoDispositivo> tipos = dispositivos.keySet();
        List<Reserva> reservas = new ArrayList<>();
        solicitacaoReserva.setReservas(reservas);
        LocalDate data = reservaDTO.getInicio();

        do {
            for (PeriodoReservaRequestPostDTO periodoDTO : reservaDTO.getPeriodos()){
                DayOfWeek diaDaSemana = data.getDayOfWeek();
                if (periodoDTO.getDiaSemana().ordinal() == diaDaSemana.ordinal()){
                    for (TipoDispositivo tipo : tipos){
                        Reserva reserva = criarReserva(reservaDTO, periodoDTO, data, solicitacaoReserva);
                        reservas.add(reserva);
                        repository.save(solicitacaoReserva);
                        criarDispositivosReservados(dispositivos,reserva, tipo);
                        repository.save(solicitacaoReserva);
                    }
                }
            }
            data = data.plusDays(1);
        } while (data.isBefore(reservaDTO.getFim().plusDays(1)));
        return solicitacaoReserva;
    }
    private Reserva criarReserva (ReservaRequestPostDTO reservaDTO, PeriodoReservaRequestPostDTO periodoDTO, LocalDate data, SolicitacaoReserva solicitacaoReserva){
        Reserva reserva = new Reserva();
        reserva.setSolicitacao(solicitacaoReserva);
        reserva.setSolicitante(new Usuario(reservaDTO.getIdUsuario()));
        reserva.setDia(data);
        reserva.setPeriodo(new Periodo(periodoDTO.getIdPeriodo()));
        reserva.setAmbiente(new Ambiente(periodoDTO.getIdAmbiente()));
        reserva.setTurma(new Turma(reservaDTO.getIdTurma()));
        return reserva;
    }

    private void criarDispositivosReservados(Map<TipoDispositivo, List<Dispositivo>> dispositivos, Reserva reserva, TipoDispositivo tipo){
        reserva.setDispositivoReservados(dispositivos.get(tipo).stream().map(dispositivo ->
                new DispositivoReservado(dispositivo, reserva)).toList());
        System.out.println(reserva);
    }
}
