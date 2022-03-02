package Model;

import java.time.LocalDateTime;

public class Agendamento extends AbstractEntity {
    private Paciente paciente;
    private Medico medico;
    private Secretaria secretaria;
    private String statusAgendamento;
    private LocalDateTime dataAgendamento;
    private LocalDateTime dataCancelamento;
    private LocalDateTime dataAvaliacao;
    private String observacao;
    private Boolean encaixe;

    public Agendamento(long id, String nome, LocalDateTime atualizado, LocalDateTime excluido, Paciente paciente, Medico medico, Secretaria secretaria, String statusAgendamento, LocalDateTime dataAgendamento, LocalDateTime dataCancelamento, LocalDateTime dataAvaliacao, String observacao, Boolean encaixe) {
        super(id, nome, atualizado, excluido);
        this.paciente = paciente;
        this.medico = medico;
        this.secretaria = secretaria;
        this.statusAgendamento = statusAgendamento;
        this.dataAgendamento = dataAgendamento;
        this.dataCancelamento = dataCancelamento;
        this.dataAvaliacao = dataAvaliacao;
        this.observacao = observacao;
        this.encaixe = encaixe;
    }

    public Agendamento(long id, String nome, LocalDateTime atualizado, LocalDateTime excluido) {
        super(id, nome, atualizado, excluido);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public String getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(String statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalDateTime getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(LocalDateTime dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Boolean getEncaixe() {
        return encaixe;
    }

    public void setEncaixe(Boolean encaixe) {
        this.encaixe = encaixe;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "paciente=" + paciente +
                ", medico=" + medico +
                ", secretaria=" + secretaria +
                ", statusAgendamento='" + statusAgendamento + '\'' +
                ", dataAgendamento=" + dataAgendamento +
                ", dataCancelamento=" + dataCancelamento +
                ", dataAvaliacao=" + dataAvaliacao +
                ", observacao='" + observacao + '\'' +
                ", encaixe=" + encaixe +
                '}';
    }
}
