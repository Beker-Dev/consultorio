package DAO;

import java.sql.*;

public class PacienteDAO {
    private Connection connection;

    public PacienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void createTablePaciente() {
        String query = "CREATE TABLE IF NOT EXISTS paciente (" +
                "paciente_id BIGSERIAL PRIMARY KEY NOT NULL," +
                "paciente_nome VARCHAR(50) NOT NULL," +
                "paciente_email VARCHAR(50) UNIQUE NOT NULL," +
                "paciente_login VARCHAR(20) UNIQUE NOT NULL," +
                "paciente_senha VARCHAR(20) NOT NULL," +
                "paciente_telefone VARCHAR(20) NOT NULL," +
                "paciente_nacionalidade VARCHAR(50) DEFAULT NULL," +
                "paciente_sexo VARCHAR(10) NOT NULL," +
                "rg VARCHAR(12)," +
                "fk_convenio INT," +
                "numero_cartao_convenio VARCHAR(50)," +
                "data_vencimento TIMESTAMP DEFAULT NULL," +
                "paciente_atualizado TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "paciente_excluido TIMESTAMP DEFAULT NULL," +
                "FOREIGN KEY (fk_convenio) REFERENCES convenio(convenio_id)" +
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
