package net.weg.wdm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wdm.controller.dto.periodo.PeriodoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.ReservaResponseDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoReservaRequestPostDTO;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reserva {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long numero;
//    @ManyToOne
//    @JoinColumn(nullable = false)
//    private Usuario solicitante;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reserva")
    private List<DispositivoReservado> dispositivoReservados;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusReserva status = StatusReserva.EM_ABERTO;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Ambiente ambiente;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Turma turma;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Periodo periodo;
    @Column(nullable = false)
    private LocalDate dia;
//    @ManyToOne
//    @JoinColumn(nullable = false)
//    @ToString.Exclude
//    @JsonIgnore
//    private SolicitacaoReserva solicitacao;
    private String comentario;

    public Reserva(SolicitacaoReservaRequestPostDTO reservaDTO, PeriodoReservaRequestPostDTO periodoDTO,
                   LocalDate data,List<DispositivoReservado> dispositivos){
        this.setDia(data);
        this.setPeriodo(new Periodo(periodoDTO.idPeriodo()));
        this.setAmbiente(new Ambiente(periodoDTO.idAmbiente()));
        this.setTurma(new Turma(reservaDTO.idTurma()));
        this.setDispositivoReservados(dispositivos);
    }

    public ReservaResponseDTO toDTO(){
        return new ReservaResponseDTO(this.status.getNOME(), this.numero, this.solicitante.getNome(),
            this.dispositivoReservados, this.ambiente,this.turma,this.periodo,this.dia,this.comentario);
    }

}
