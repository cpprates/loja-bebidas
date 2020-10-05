package model;

public class Cerveja extends Bebida {
    private String cor;
    private double ibu, alcool;

    public Cerveja(String nome, String estilo, double ibu, String cor, double alcool) {
        super(nome, estilo);
        this.ibu = ibu;
        this.cor = cor;
        this.alcool = alcool;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getIbu() {
        return ibu;
    }

    public void setIbu(double ibu) {
        this.ibu = ibu;
    }

    public double getAlcool() {
        return alcool;
    }

    public void setAlcool(double alcool) {
        this.alcool = alcool;
    }

    @Override
    public String material() {
        return "A cerveja " + nome + " estilo " + estilo + " é feita com:\nMalte, lúpulo, fermento e água.";
    }

    @Override
    public String fabricacao() {
        return "Moagem, mosturacao, clarificacao, fervura, fermentacao e maturacao";
    }

    @Override
    public String maturacao() {
        return "A maturacão da cerveja " + nome + " de estilo " + estilo
                + "\n é feita em barril de alumínio entre 0 e 3*C por um período de 5 a 15 dias.";
    }

    @Override
    public String conservacao() {
        return "A conservacão da cerveja " + nome + " estilo " + estilo + "\nse dá pela refrigeracão leve à 15*C";
    }

    @Override
    public String transportacao() {
        return "A cerveja " + nome + " estilo " + estilo
                + "\ndeve ser transportada na vertical em caixa de papelão com 6 unidades";
    }

    @Override
    public String toString() {
        return "🍺 * " + super.toString() + " * " + ibu + " * " + cor + " * " + alcool;
    }

}
