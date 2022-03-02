package Model;

public abstract class Pessoa extends AbstractEntity {
    private String nome;  // tirar o nome fora pq ta no abstractentity
    private String telefone;
    private String email;
    private String login;
    private String senha;
    private String nacionalidade;
    private Sexo sexo;

    public Pessoa(String nome, String telefone, String email, String login, String senha, String nacionalidade, Sexo sexo) {
        this.telefone = telefone;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.nacionalidade = nacionalidade;
        this.sexo = sexo;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", sexo=" + sexo +
                '}';
    }
}
