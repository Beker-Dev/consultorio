package br.com.uniamerica.api.service;

import br.com.uniamerica.api.entity.Secretaria;
import br.com.uniamerica.api.repository.SecretariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


public class SecretariaService {
    @Autowired
    private SecretariaRepository secretariaRepository;

    public Optional<Secretaria> findById(Long id){
        return this.secretariaRepository.findById(id);
    }
    public Page<Secretaria> listAll(Pageable pageable){
        return this.secretariaRepository.findAll(pageable);
    }

    @Transactional
    public void update(Long id, Secretaria secretaria){
        if (id == secretaria.getId()) {
            this.secretariaRepository.save(secretaria);
        }
        else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void insert(Secretaria secretaria){
        this.secretariaRepository.save(secretaria);
    }

    @Transactional
    public void updateStatus(Long id, Secretaria secretaria){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        dtf.format(LocalDateTime.now());
        if (id == secretaria.getId()) {
            this.secretariaRepository.updateStatus(secretaria.getId(), dtf);
        }
        else {
            throw new RuntimeException();
        }
    }
    @Transactional
    public void desativar(Long id, Secretaria secretaria){
        if (id == secretaria.getId()) {
            this.secretariaRepository.desativar(secretaria.getId());
        }
        else {
            throw new RuntimeException("Error: Não foi possivel editar a Secretaria, valores inconsistentes.");
        }
    }
}
