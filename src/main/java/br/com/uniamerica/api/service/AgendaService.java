package br.com.uniamerica.api.service;

import br.com.uniamerica.api.entity.Agenda;
import br.com.uniamerica.api.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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
    public void insert(Agenda agenda) {
        this.validarFormulario(agenda);
        this.agendaRepository.save(agenda);
    }

    public void updateStatus(Long id, Agenda agenda){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        dtf.format(LocalDateTime.now());
        if (id == agenda.getId()) {
            this.agendaRepository.updateStatus(agenda.getId(), dtf);
        }
        else {
            throw new RuntimeException();
        }
    }

    public void validarFormulario(Agenda agenda) {
        if (agenda.getData() == null || agenda.getPaciente().getId() == null || agenda.getMedico().getId() == null) {
            throw new RuntimeException("Data ou Paciente ou Medico sao invalidos");
        }
        else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            dtf.format(agenda.getData());
            List<Long> agendaExiste = agendamentoExiste(agenda, dtf);
            if (agendaExiste.size() > 0) {
                throw new RuntimeException("Paciente ja possui agendamento ou Horario ja esta marcado");
            }
        }
    }

    @Transactional
    public List<Long> agendamentoExiste(Agenda agenda, DateTimeFormatter dtf) {
        Long idMedico = agenda.getMedico().getId();
        Long idPaciente = agenda.getPaciente().getId();
        List<Long> result = this.agendaRepository.agendamentoExiste(agenda, idMedico, idPaciente, dtf);
        return result;
    }
}
