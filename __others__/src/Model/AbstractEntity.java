package Model;

import java.time.LocalDateTime;

public abstract class AbstractEntity {
    private long id;
    private String nome;
    private LocalDateTime atualizado;
    private LocalDateTime excluido;

    public AbstractEntity(long id, String nome, LocalDateTime atualizado, LocalDateTime excluido) {
        this.id = id;
        this.nome = nome;
        this.atualizado = atualizado;
        this.excluido = excluido;
    }

    public AbstractEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(LocalDateTime atualizado) {
        this.atualizado = atualizado;
    }

    public LocalDateTime getExcluido() {
        return excluido;
    }

    public void setExcluido(LocalDateTime excluido) {
        this.excluido = excluido;
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", atualizado=" + atualizado +
                ", excluido=" + excluido +
                '}';
    }
}
