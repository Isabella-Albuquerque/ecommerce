package ecommerce.model;

public class Fruta extends Produto {
    private String tipo;

    public Fruta(int id, String nome, double preco, String tipo) {
        super(id, nome, preco);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public double calcularPreco() {
        return getPreco();
    }
}
