package br.com.uniamerica.api.repository;

import br.com.uniamerica.api.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.format.DateTimeFormatter;
import java.util.List;


@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {


    @Query("SELECT new Medico(medico.id, medico.nome, medico.crm) FROM Medico medico")
    public List<Medico> listTable();

    @Modifying
    @Query("UPDATE Medico medico " +
            "SET medico.excluido = :now " +
            "WHERE medico.id = :medico")
    public void updateStatus(@Param("medico") Long idMedico, @Param("now") DateTimeFormatter now);

    @Modifying
    @Query("UPDATE Medico medico SET medico.excluido = true WHERE medico.id = :idMedico")
    public void desativar(@Param("idMedico") Long idMedico);
}
