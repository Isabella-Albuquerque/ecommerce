package ecommerce.model;

public abstract class Produto {
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

   
    public abstract double calcularPreco();

    @Override
    public String toString() {
        return id + " - " + nome + " - R$ " + preco;
    }
}