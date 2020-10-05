package model;

public class Vinho extends Bebida {
    private String uva, barril;
    private double alcool;

    public Vinho(String nome, String estilo, String uva, String barril, double alcool) {
        super(nome, estilo);
        this.uva = uva;
        this.barril = barril;
        this.alcool = alcool;
    }

    public String getBarril() {
        return barril;
    }

    public void setBarril(String barril) {
        this.barril = barril;
    }

    public double getAlcool() {
        return alcool;
    }

    public void setAlcool(double alcool) {
        this.alcool = alcool;
    }

    @Override
    public String material() {
        return "Uva e barris de carvalho";
    }

    @Override
    public String fabricacao() {
        return "A fabricacao do vinho " + getNome() + " de estilo " + getEstilo()
                + " consiste nas etapas:\nColheita, Esmagamento, Prensagem,\nFermentacao, Trasfega, Clarificacão e Estabilizacão, Amadurecimento e Engarrafamento.";
    }

    @Override
    public String maturacao() {
        return "A maturacao do vinho " + getNome() + " de estilo " + getEstilo()
                + " ocorre dentro do barril de carvalho (ou alumínio) por 2 ou 3 anos.";
    }

    @Override
    public String conservacao() {
        return "O vinho " + getNome() + " de estilo" + getEstilo()
                + " deve ser conservado em temperaturas até 20*C na horizontal.";
    }

    @Override
    public String transportacao() {
        return "O vinho " + getNome() + " de estilo" + getEstilo()
                + " deve ser transportado na vertical\nem caixas para capacidade de 6 unidades com uma divisão de papelão para que as garrafas não se choquem\ne em temperatura ideal de 10*C.";
    }

    public String getUva() {
        return uva;
    }

    public void setUva(String uva) {
        this.uva = uva;
    }

    @Override
    public String toString() {
        return "🍷 * " + super.toString() + " * " + uva + " * " + barril + " * " + alcool;
    }

}
