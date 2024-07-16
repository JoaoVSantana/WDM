package net.weg.wdm.controller;

import lombok.AllArgsConstructor;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoReservaResponseDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoResponseDTO;
import net.weg.wdm.entity.SolicitacaoReserva;
import net.weg.wdm.service.SolicitacaoReservaServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/solicitacao")
public class SolicitacaoReservaController {

    private SolicitacaoReservaServiceImpl solicitacaoReservaService;
    @PostMapping
    public ResponseEntity<SolicitacaoReserva> cadastroSolicitacao(@RequestBody SolicitacaoReservaRequestPostDTO reservaDTO){
        solicitacaoReservaService.criarSolicitacaoReserva(reservaDTO);
        return new ResponseEntity<>(solicitacaoReservaService.criarSolicitacaoReserva(reservaDTO), HttpStatus.OK);
//        return new ResponseEntity<>(new Reserva(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoReserva> buscarSolicitacao(@PathVariable Long id){
        return new ResponseEntity<>(solicitacaoReservaService.buscarSolicitacao(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SolicitacaoReservaResponseDTO>> buscarTodasSolicitacoes(){
        return new ResponseEntity<>(solicitacaoReservaService.buscarTodasSolicitacoes(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<SolicitacaoResponseDTO>> buscarTodasSolicitacoesPage(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 5) Pageable pageable){
        return new ResponseEntity<>(solicitacaoReservaService.buscarTodasSolicitacoesPage(pageable), HttpStatus.OK);
    }
}
