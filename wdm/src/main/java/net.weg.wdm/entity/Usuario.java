package net.weg.wdm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Usuario {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String nome;
    @Column(unique = true, nullable = false, length = 200)
    private String email;
    @Column(nullable = false)
    private String senha;
    private Boolean habilidato;
//    @OneToMany()
//    @JoinColumn(name = "id_solicitante")
//    private List<SolicitacaoReserva> reservas;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo;
    @OneToMany(mappedBy = "usuario")
    private List<GrupoDispositivo> gruposDispositivos;
}
