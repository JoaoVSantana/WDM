package net.weg.wdm.service;

import lombok.AllArgsConstructor;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoReservaResponseDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoResponseDTO;
import net.weg.wdm.entity.*;
import net.weg.wdm.repository.SolicitacaoReservaRepository;
import net.weg.wdm.service.interfaces.SolicitacaoReservaServiceInt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SolicitacaoReservaServiceImpl implements SolicitacaoReservaServiceInt {

    //Se ta cascade busca as informaçoes do banco antes de fazer um put ou patch

    private final DispositivoServiceImpl dispositivoService;
    private  final SolicitacaoReservaRepository repository;
    @Override
    public SolicitacaoReserva criarSolicitacaoReserva(SolicitacaoReservaRequestPostDTO reservaDTO) {

        Map<TipoDispositivo, List<Dispositivo>> dispositivos = dispositivoService.buscarDispositivosPorIdSeparadosPorTipo
                (reservaDTO.idDispositivos());

        SolicitacaoReserva solicitacaoReserva = new SolicitacaoReserva(reservaDTO, dispositivos);
        return repository.save(solicitacaoReserva);
    }
    @Override
    public SolicitacaoReserva buscarSolicitacao(Long id) {
        return repository.findById(id).get();
    }
    @Override
    public List<SolicitacaoReservaResponseDTO> buscarTodasSolicitacoes(){
        List<SolicitacaoReserva> solicitacoes = repository.findAll();
        List<SolicitacaoReservaResponseDTO> response = solicitacoes.stream().map(
                solicitacaoReserva -> solicitacaoReserva.toDTO()).toList();
        return response;
    }
    @Override
    public Page<SolicitacaoResponseDTO> buscarTodasSolicitacoesPage(Pageable pageable){
        return repository.findAll(pageable).map(solicitacao -> solicitacao.paraOutraDTO());
    }
}
