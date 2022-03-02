package DAO;

import java.sql.*;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/consultorio", "postgres", "pgadmin");
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }

// reset table:
//    drop table agendamento;
//    drop table paciente;
//    drop table convenio;
//    drop table medico;
//    drop table especialidade;
//    drop table secretaria;


}
