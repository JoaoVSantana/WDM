package net.weg.wdm.service;

import lombok.AllArgsConstructor;
import net.weg.wdm.entity.Usuario;
import net.weg.wdm.repository.UsuarioRepository;
import net.weg.wdm.service.interfaces.UsuarioServiceInt;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioServiceInt {


    private final UsuarioRepository usuarioRepository;
    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).get();
    }
}
