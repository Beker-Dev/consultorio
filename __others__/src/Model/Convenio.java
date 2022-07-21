package Model;


import java.time.LocalDateTime;

public class Convenio extends AbstractEntity{
    public Convenio(long id, String nome, LocalDateTime atualizado, LocalDateTime excluido) {
        super(id, nome, atualizado, excluido);
    }

    @Override
    public String toString() {
        return "Convenio{}";
    }
}
