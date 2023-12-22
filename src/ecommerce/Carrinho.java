package ecommerce;

import java.util.ArrayList;
import java.util.List;

import ecommerce.model.ItemCarrinho;
import ecommerce.model.Produto;

public class Carrinho implements CarrinhoCompras {
    private List<ItemCarrinho> itens;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    @Override
    public void adicionarItem(Produto produto, int quantidade) {
        ItemCarrinho itemExistente = encontrarItem(produto);

        if (itemExistente != null) {
            itemExistente.setQuantidade(itemExistente.getQuantidade() + quantidade);
        } else {
            ItemCarrinho novoItem = new ItemCarrinho(produto, quantidade);
            itens.add(novoItem);
        }
    }

    @Override
    public void limparCarrinho() {
        itens.clear();
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    @Override
    public List<ItemCarrinho> getItens() {
        return itens;
    }

    @Override
    public void exibirItens() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio.");
        } else {
            for (ItemCarrinho item : itens) {
                System.out.println(item);
            }
        }
    }

    private ItemCarrinho encontrarItem(Produto produto) {
        for (ItemCarrinho item : itens) {
            if (item.getProduto().getId() == produto.getId()) {
                return item;
            }
        }
        return null;
    }
}
