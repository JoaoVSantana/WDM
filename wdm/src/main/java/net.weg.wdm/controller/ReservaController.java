package net.weg.wdm.controller;

import lombok.AllArgsConstructor;
import net.weg.wdm.controller.dto.ReservaRequestPostDTO;
import net.weg.wdm.entity.SolicitacaoReserva;
import net.weg.wdm.service.SolicitacaoReservaServiceImpl;
import net.weg.wdm.service.interfaces.ReservaServiceInt;
import net.weg.wdm.service.interfaces.SolicitacaoReservaServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    private SolicitacaoReservaServiceImpl solicitacaoReservaService;
    //ResponseEntity é uma entidade que serve para receber uma resposta http
    @PostMapping
    public ResponseEntity<SolicitacaoReserva> cadastroReserva(@RequestBody ReservaRequestPostDTO reservaDTO){
        solicitacaoReservaService.criarSolicitacaoReserva(reservaDTO);
        return new ResponseEntity<>(solicitacaoReservaService.criarSolicitacaoReserva(reservaDTO), HttpStatus.OK);
//        return new ResponseEntity<>(new Reserva(), HttpStatus.OK);
    }
}
