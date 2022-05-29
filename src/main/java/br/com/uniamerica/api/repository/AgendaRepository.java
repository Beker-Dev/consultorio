package br.com.uniamerica.api.repository;

import br.com.uniamerica.api.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
            "SELECT agenda.id FROM Agenda agenda WHERE agenda.medico = :idMedico AND agenda.data = :horaAgenda" +
            " OR agenda.paciente = :idPaciente AND agenda.data = :horaAgenda" +
            " AND agenda.data BETWEEN :horaInicio AND :horaEntradaAlmoco AND agenda.data BETWEEN :horaSaidaAlmoco AND :horaFim"
    )
    public List<Long> agendamentoExiste(
            @Param("agenda") Agenda agenda,
            @Param("idMedico") Long idMedico,
            @Param("idPaciente") Long idPaciente,
            @Param("horaAgenda") LocalDateTime horaAgenda,
            @Param("horaInicio") LocalDateTime horaInicio,
            @Param("horaFim") LocalDateTime horaFim,
            @Param("horaEntradaAlmoco") LocalDateTime horaEntradaAlmoco,
            @Param("horaSaidaAlmoco") LocalDateTime horaSaidaAlmoco
    );
}
