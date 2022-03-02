package Model;

import java.time.LocalDateTime;

public class Paciente extends Pessoa {
    private String convenio;
    private String numeroCartaoConvenio;
    private LocalDateTime dataVencimento;
    private String rg;

    public Paciente(String nome, String telefone, String email, String login, String senha, String nacionalidade, Sexo sexo, String convenio, String numeroCartaoConvenio, LocalDateTime dataVencimento, String rg) {
        super(nome, telefone, email, login, senha, nacionalidade, sexo);
        this.convenio = convenio;
        this.numeroCartaoConvenio = numeroCartaoConvenio;
        this.dataVencimento = dataVencimento;
        this.rg = rg;
    }

    public Paciente() {
    }

    public Paciente(String convenio) {
        this.convenio = convenio;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getNumeroCartaoConvenio() {
        return numeroCartaoConvenio;
    }

    public void setNumeroCartaoConvenio(String numeroCartaoConvenio) {
        this.numeroCartaoConvenio = numeroCartaoConvenio;
    }

    public LocalDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "convenio='" + convenio + '\'' +
                ", numeroCartaoConvenio='" + numeroCartaoConvenio + '\'' +
                ", dataVencimento=" + dataVencimento +
                ", rg='" + rg + '\'' +
                '}';
    }
}
