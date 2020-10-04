package model;

public class Cerveja extends Bebida {
    private String malte, fermento, lupulo;
    private int quantMalte, quantFermento, quantLupulo;

    public Cerveja(String nome, String estilo, String malte, String fermento, String lupulo) {
        super(nome, estilo);
        this.malte = malte;
        this.fermento = fermento;
        this.lupulo = lupulo;
    }

    @Override
    public String material() {
        return "A cerveja " + null + " estilo " + null + " é feita com:\nMalte, lúpulo, fermento e água.";
    }

    @Override
    public String fabricacao() {
        return "Moagem, mosturacao, clarificacao, fervura, fermentacao e maturacao";
    }

    @Override
    public String maturacao() {
        return "A maturacão da cerveja " + null + " de estilo " + null
                + "\n é feita em barril de alumínio entre 0 e 3*C por um período de 5 a 15 dias.";
    }

    @Override
    public String conservacao() {
        return "A conservacão da cerveja " + null + " estilo " + null + "\nse dá pela refrigeracão leve à 15*C";
    }

    @Override
    public String transportacao() {
        return "A cerveja " + null + " estilo " + null
                + "\ndeve ser transportada na vertical em caixa de papelão com 6 unidades";
    }

    @Override
    public String toString() {
        return "[🍺Cerveja: " + null + "\nEstilo: " + null + "\nMalte: " + malte + "\nFermento: " + fermento
                + "\nLúpulo: " + lupulo + "]";
    }

    public void setFermento(String fermento) {
        this.fermento = fermento;
    }

    public void setLupulo(String lupulo) {
        this.lupulo = lupulo;
    }

    public void setMalte(String malte) {
        this.malte = malte;
    }

    public void setQuantFermento(int quantFermento) {
        this.quantFermento = quantFermento;
    }

    public void setQuantLupulo(int quantLupulo) {
        this.quantLupulo = quantLupulo;
    }

    public void setQuantMalte(int quantMalte) {
        this.quantMalte = quantMalte;
    }

    public String getFermento() {
        return fermento;
    }

    public String getLupulo() {
        return lupulo;
    }

    public String getMalte() {
        return malte;
    }

    public int getQuantFermento() {
        return quantFermento;
    }

    public int getQuantLupulo() {
        return quantLupulo;
    }

    public int getQuantMalte() {
        return quantMalte;
    }

}
