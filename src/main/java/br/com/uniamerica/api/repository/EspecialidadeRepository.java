package br.com.uniamerica.api.repository;

import br.com.uniamerica.api.entity.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.format.DateTimeFormatter;


@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {

    /**
     *
     * @param especialidade
     */
    @Modifying
    @Query("UPDATE Especialidade especialidade " +
            "SET especialidade.excluido = :now " +
            "WHERE especialidade.id = :especialidade")
    public void updateStatus(@Param("especialidade") Long idEspecialidade, @Param("now") DateTimeFormatter now);

    @Modifying
    @Query("UPDATE Especialidade especialidade SET especialidade.excluido = true " +
            "WHERE especialidade.id = :idEspecialidade ")
    public void desativar(@Param("idEspecialidade") Long idEspecialidade);
}
