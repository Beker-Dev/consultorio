package br.com.uniamerica.api.service;

import br.com.uniamerica.api.entity.Agenda;
import br.com.uniamerica.api.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public Optional<Agenda> findById(Long id) {return this.agendaRepository.findById(id);}

    public Page<Agenda> listAll(Pageable pageable) {return this.agendaRepository.findAll(pageable);}

    @Transactional
    public void update(Long id, Agenda agenda) {
        if (id == agenda.getId()) {
            this.agendaRepository.save(agenda);
        }
        else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void insert(Agenda agenda) {this.agendaRepository.save(agenda);}

}
