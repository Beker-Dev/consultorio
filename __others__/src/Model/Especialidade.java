package Model;

import java.time.LocalDateTime;

public class Especialidade extends AbstractEntity{
    @Override
    public String toString() {
        return "Especialidade{}";
    }

    public Especialidade(long id, String nome, LocalDateTime atualizado, LocalDateTime excluido) {
        super(id, nome, atualizado, excluido);

    }
}
