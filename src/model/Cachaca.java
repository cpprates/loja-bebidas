package model;

public class Cachaca extends Bebida {
    private String cana, barril;
    private double alcool;

    public Cachaca(String nome, String estilo, String cana, String barril, double alcool) {
        super(nome, estilo);
        this.cana = cana;
        this.barril = barril;
        this.alcool = alcool;
    }

    public double getAlcool() {
        return alcool;
    }

    public void setAlcool(double alcool) {
        this.alcool = alcool;
    }

    public String getBarril() {
        return barril;
    }

    public void setBarril(String barril) {
        this.barril = barril;
    }

    public String getCana() {
        return cana;
    }

    public void setCana(String cana) {
        this.cana = cana;
    }

    @Override
    public String material() {
        return "Cana de acúcar, água potável, fubá de milho e farelo de arroz.";
    }

    @Override
    public String fabricacao() {
        return "A cachaca " + getNome() + " estilo " + getEstilo()
                + " é fabricada seguindo o processo:\nMoagem, destilacao, fermentacao e envelhecimento.";
    }

    @Override
    public String maturacao() {
        return "A maturacão ocorre na etapa de envelhecimento.";
    }

    @Override
    public String conservacao() {
        return "A conservacão da cachaca " + getNome() + " estilo " + getEstilo()
                + "\né feita em garrafa de vidro na temperatura ambiente por até 20 anos.";
    }

    @Override
    public String transportacao() {
        return "A transportacao da cachaca " + getNome() + " estilo " + getEstilo()
                + "\né feita em garrafa de vidro na vertical em caixa de papelão com 6 unidades";
    }

    @Override
    public String toString() {
        return "🍸 * " + super.toString() + " * " + cana + " * " + barril + " * " + alcool;
    }

}
