package net.weg.wdm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reserva {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long numero;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario solicitante;
    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
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
    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private SolicitacaoReserva solicitacao;
    private String comentario;


}
