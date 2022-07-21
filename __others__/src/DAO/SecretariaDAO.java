package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SecretariaDAO {
    private Connection connection;

    public SecretariaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void createTableSecretaria() {
        String query = "CREATE TABLE IF NOT EXISTS secretaria (" +
                "secretaria_id BIGSERIAL PRIMARY KEY NOT NULL," +
                "secretaria_nome VARCHAR(50) NOT NULL," +
                "secretaria_email VARCHAR(50) UNIQUE NOT NULL," +
                "secretaria_login VARCHAR(20) UNIQUE NOT NULL," +
                "secretaria_senha VARCHAR(20) NOT NULL," +
                "secretaria_telefone VARCHAR(20) NOT NULL," +
                "secretaria_nacionalidade VARCHAR(50) DEFAULT NULL," +
                "secretaria_sexo VARCHAR(10) NOT NULL," +
                "salario NUMERIC DEFAULT NULL," +
                "dataContratacao TIMESTAMP DEFAULT NULL," +
                "pis VARCHAR(50) DEFAULT NULL," +
                "secretaria_atualizado TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "secretaria_excluido TIMESTAMP DEFAULT NULL" +
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
