package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgendamentoDAO {

    private Connection connection;

    public AgendamentoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void createTableAgendamento() {
        String query = "CREATE TABLE IF NOT EXISTS agendamento (" +
                "fk_paciente_id INT NOT NULL," +
                "fk_medico_id INT NOT NULL," +
                "fk_secretaria_id INT," +
                "status_agendamento VARCHAR(10) NOT NULL," +
                "data_agendamento TIMESTAMP DEFAULT NULL," +
                "data_cancelamento TIMESTAMP DEFAULT NULL," +
                "data_avaliacao TIMESTAMP DEFAULT NULL," +
                "observacao VARCHAR(150) NOT NULL," +
                "encaixe BOOLEAN DEFAULT FALSE," +
                "atualizado TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "FOREIGN KEY (fk_paciente_id) REFERENCES paciente(paciente_id)," +
                "FOREIGN KEY (fk_medico_id) REFERENCES medico(medico_id)," +
                "FOREIGN KEY (fk_secretaria_id) REFERENCES secretaria(secretaria_id)" +
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
