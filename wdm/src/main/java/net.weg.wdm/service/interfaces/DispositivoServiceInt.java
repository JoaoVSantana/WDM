package net.weg.wdm.service.interfaces;

import net.weg.wdm.entity.Dispositivo;
import net.weg.wdm.entity.TipoDispositivo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DispositivoServiceInt {
    Map<TipoDispositivo, List<Dispositivo>> buscarDispositivosPorIdSeparadosPorTipo(List<Long>id);
}
