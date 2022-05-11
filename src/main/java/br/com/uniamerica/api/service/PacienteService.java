package br.com.uniamerica.api.service;

import br.com.uniamerica.api.entity.Paciente;
import br.com.uniamerica.api.entity.TipoAtendimento;
import br.com.uniamerica.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    Optional<Paciente> findById(Long id) {return this.pacienteRepository.findById(id);}

    Page<Paciente> findAll(Pageable pageable) {return this.pacienteRepository.findAll(pageable);}

    public void update(Long id, Paciente paciente) {
        if (id == paciente.getId()) {
            this.validarFormulario(paciente);
            this.saveTransactional(paciente);
        }
        else {
            throw new RuntimeException();
        }
    }

    public void insert(Paciente paciente) {
        this.validarFormulario(paciente);
        this.saveTransactional(paciente);
    }

    @Transactional
    public void saveTransactional(Paciente paciente) {
        this.pacienteRepository.save(paciente);
    }

    @Transactional
    public void updateStatus(Long id, Paciente paciente) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        dtf.format(LocalDateTime.now());
        if (id == paciente.getId()) {
            this.pacienteRepository.updateStatus(paciente.getId(), dtf);
        }
        else {
            throw new RuntimeException();
        }
    }

    public void validarFormulario(Paciente paciente) {
        if (paciente.getTipoAtendimento().equals(TipoAtendimento.convenio)) {
            if (paciente.getConvenio() == null || paciente.getConvenio().getId() == null) {
                throw new RuntimeException("convenio nao informado");
            }
            if (paciente.getNumeroCartaoConvenio().isBlank()) {
                throw new RuntimeException("cartao convenio nao informado");
            }
            if (paciente.getDataVencimento() == null) {
                throw new RuntimeException("data de vencimento do cartao nao informado");
            }
            if (paciente.getDataVencimento().compareTo(LocalDateTime.now()) > 0) {
                throw new RuntimeException("data de vencimento do cartao esta expirada");
            }
        }
        if (paciente.getTipoAtendimento().equals(TipoAtendimento.particular)) {
            paciente.setConvenio(null);
            paciente.setNumeroCartaoConvenio(null);
            paciente.setDataVencimento(null);
        }
    }
}
