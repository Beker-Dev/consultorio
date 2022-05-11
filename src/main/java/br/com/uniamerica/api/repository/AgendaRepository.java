package br.com.uniamerica.api.repository;

import br.com.uniamerica.api.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.format.DateTimeFormatter;
import java.util.List;


@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    @Modifying
    @Query("UPDATE Agenda agenda " +
            "SET agenda.excluido = :now " +
            "WHERE agenda.id = :agenda")
    public void updateStatus(@Param("agenda") Long idAgenda, @Param("now") DateTimeFormatter now);

    @Query(
            "SELECT agenda.id FROM Agenda agenda WHERE agenda.medico = :idMedico AND agenda.data = :dtf" +
            " OR agenda.paciente = :idPaciente AND agenda.data = :dtf"
    )
    public List<Long> agendamentoExiste(@Param("agenda") Agenda agenda, @Param("idMedico") Long idMedico, @Param("idPaciente") Long idPaciente, @Param("dtf") DateTimeFormatter dtf);
}
//"agenda.id_paciente = :agenda.id_paciente AND"