package br.com.uniamerica.api.repository;

import br.com.uniamerica.api.entity.Secretaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.format.DateTimeFormatter;


@Repository
public interface SecretariaRepository extends JpaRepository<Secretaria, Long> {
    @Modifying
    @Query("UPDATE Secretaria secretaria " +
            "SET secretaria.excluido = :now " +
            "WHERE secretaria.id = :secretaria")
    public void updateStatus(@Param("secretaria") Long idSecretaria, @Param("now") DateTimeFormatter now);

    @Modifying
    @Query("UPDATE Secretaria secretaria SET secretaria.excluido = true WHERE secretaria.id = :idSecretaria")
    public void desativar(@Param("idSecretaria") Long idSecretaria);
}
