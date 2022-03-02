package DAO;

import Model.Especialidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EspecialidadeDAO {

    private Connection connection;

    public EspecialidadeDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void createTableEspecialidade() {
        String query = "CREATE TABLE IF NOT EXISTS especialidade (" +
                "especialidade_id BIGSERIAL PRIMARY KEY NOT NULL," +
                "especialidade_nome VARCHAR(50) NOT NULL," +
                "especialidade_atualizado TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "especialidade_excluido TIMESTAMP DEFAULT NULL" +
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
