package Model;

public enum Sexo {
    MASCULINO("masculino"),
    FEMININO("feminino"),
    OUTRO("outro");

    private final String valor;

    Sexo(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
