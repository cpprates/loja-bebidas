package model;

public abstract class Bebida {
    protected String nome, estilo;

    public Bebida(String nome, String estilo) {
        this.nome = nome;
        this.estilo = estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstilo() {
        return estilo;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + " * " + estilo;
    }

    public abstract String material();

    public abstract String fabricacao();

    public abstract String maturacao();

    public abstract String conservacao();

    public abstract String transportacao();

}
