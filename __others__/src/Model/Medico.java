package Model;

import java.math.BigDecimal;

public class Medico extends Pessoa {
    private String crm;
    private BigDecimal porcentagemParticipacao;
    private String consultorio;
    private String especialidade;

    public Medico(String nome, String telefone, String email, String login, String senha, String nacionalidade, Sexo sexo, String crm, BigDecimal porcentagemParticipacao, String consultorio, String especialidade) {
        super(nome, telefone, email, login, senha, nacionalidade, sexo);
        this.crm = crm;
        this.porcentagemParticipacao = porcentagemParticipacao;
        this.consultorio = consultorio;
        this.especialidade = especialidade;
    }

    public Medico(String nome, String telefone, String email, String login, String senha, String nacionalidade, Sexo sexo) {
        super(nome, telefone, email, login, senha, nacionalidade, sexo);
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public BigDecimal getPorcentagemParticipacao() {
        return porcentagemParticipacao;
    }

    public void setPorcentagemParticipacao(BigDecimal porcentagemParticipacao) {
        this.porcentagemParticipacao = porcentagemParticipacao;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "crm='" + crm + '\'' +
                ", porcentagemParticipacao=" + porcentagemParticipacao +
                ", consultorio='" + consultorio + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }
}
