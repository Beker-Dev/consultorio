package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConvenioDAO {
    private Connection connection;

    public ConvenioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void createTableConvenio() {
        String query = "CREATE TABLE IF NOT EXISTS convenio (" +
                "convenio_id BIGSERIAL PRIMARY KEY NOT NULL," +
                "convenio_nome VARCHAR(50) NOT NULL," +
                "convenio_atualizado TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "convenio_excluido TIMESTAMP DEFAULT NULL" +
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
