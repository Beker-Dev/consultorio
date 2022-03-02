import DAO.*;
import Model.*;

public class Main {
    public static void main(String[] args) {
        ConvenioDAO table2 = new ConvenioDAO();
        EspecialidadeDAO table3 = new EspecialidadeDAO();
        PacienteDAO table5 = new PacienteDAO();
        MedicoDAO table6 = new MedicoDAO();
        SecretariaDAO table7 = new SecretariaDAO();
        AgendamentoDAO table8 = new AgendamentoDAO();

        table2.createTableConvenio();
        table3.createTableEspecialidade();
        table5.createTablePaciente();
        table6.createTableMedico();
        table7.createTableSecretaria();
        table8.createTableAgendamento();

    }

}
