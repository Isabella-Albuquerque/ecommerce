package ecommerce.model;

public class Verdura extends Produto {
 
    public Verdura(int id, String nome, double preco) {
        super(id, nome, preco);
    }

    @Override
    public double calcularPreco() {
        return getPreco();
    }
}
