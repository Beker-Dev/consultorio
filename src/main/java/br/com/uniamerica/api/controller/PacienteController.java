package br.com.uniamerica.api.controller;

import br.com.uniamerica.api.entity.Paciente;
import br.com.uniamerica.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    public PacienteRepository pacienteRepository;

    /**
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Paciente>> listAllPacientes(){
        List<Paciente> pacientes = pacienteRepository.findAll();
        return new ResponseEntity<>(pacienteRepository.findAll(), HttpStatus.OK) ;
    }

    /**
     *
     * @param paciente
     * @return
     */
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Paciente paciente){
        pacienteRepository.save(paciente);
        return new ResponseEntity<>("Registro Cadastrado", HttpStatus.OK);
    }
}
