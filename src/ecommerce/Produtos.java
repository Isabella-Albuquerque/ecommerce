package ecommerce;

import java.util.ArrayList;
import java.util.List;
import ecommerce.model.Produto;
import ecommerce.model.Fruta;
import ecommerce.model.Verdura;

public class Produtos {
    private List<Produto> listaProdutos;

    public Produtos() {
        this.listaProdutos = new ArrayList<>();
        inicializarProdutos();
    }

    private void inicializarProdutos() {
        listaProdutos.add(new Fruta(1, "Abacaxi", 4.99, "Tropical"));
        listaProdutos.add(new Fruta(2, "Banana", 2.99, "Prata"));
        listaProdutos.add(new Fruta(3, "Laranja", 2.59, "Bahia"));
        listaProdutos.add(new Fruta(4, "Lichia", 6.29, "Chinesa"));
        listaProdutos.add(new Fruta(5, "Manga", 4.99, "Tommy Atkins"));
        listaProdutos.add(new Verdura(7, "Alface Orgânica", 2.99));
  }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public Produto encontrarProdutoPorId(int idProduto) {
        for (Produto produto : listaProdutos) {
            if (produto.getId() == idProduto) {
                return produto;
            }
        }
        return null;
    }
}
