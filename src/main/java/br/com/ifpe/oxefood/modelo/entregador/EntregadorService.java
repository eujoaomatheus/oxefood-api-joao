package br.com.ifpe.oxefood.modelo.entregador;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    @Transactional
    public Entregador save(Entregador entregador) {
        entregador.setHabilitado(Boolean.TRUE);
        entregador.setVersao(1L);
        entregador.setDataCriacao(LocalDate.now());
        return repository.save(entregador);
    }

    public List<Entregador> listarTodos() {

        List<Entregador> entregadores = repository.findAll();

        return entregadores;
    }

    public Entregador obterPorID(Long id) {

        Optional<Entregador> entregador = repository.findById(id);

        return entregador.orElse(null);
    }
}
