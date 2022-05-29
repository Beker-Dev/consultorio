package br.com.uniamerica.api.repository;

import br.com.uniamerica.api.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.format.DateTimeFormatter;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    @Modifying
    @Query("UPDATE Paciente paciente " +
            "SET paciente.excluido =  :now " +
            "WHERE paciente.id = :convenio")
    public void updateStatus(@Param("paciente") Long idPaciente, @Param("now") DateTimeFormatter now);
}
