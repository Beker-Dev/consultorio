package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicoDAO {
    private Connection connection;

    public MedicoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void createTableMedico() {
        String query = "CREATE TABLE IF NOT EXISTS medico (" +
                "medico_id BIGSERIAL PRIMARY KEY NOT NULL," +
                "medico_nome VARCHAR(50) NOT NULL," +
                "medico_email VARCHAR(50) UNIQUE NOT NULL," +
                "medico_login VARCHAR(20) UNIQUE NOT NULL," +
                "medico_senha VARCHAR(20) NOT NULL," +
                "medico_telefone VARCHAR(20) NOT NULL," +
                "medico_nacionalidade VARCHAR(50) DEFAULT NULL," +
                "medico_sexo VARCHAR(10) NOT NULL," +
                "crm VARCHAR(15) NOT NULL," +
                "porcentagem_participacao NUMERIC DEFAULT NULL," +
                "consultorio VARCHAR(50) DEFAULT NULL," +
                "fk_especialidade INT," +
                "medico_atualizado TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "medico_excluido TIMESTAMP DEFAULT NULL," +
                "FOREIGN KEY (fk_especialidade) REFERENCES especialidade(especialidade_id)" +
                ")";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
