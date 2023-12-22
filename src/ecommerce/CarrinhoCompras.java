package ecommerce;

import java.util.List;

import ecommerce.model.ItemCarrinho;
import ecommerce.model.Produto;

public interface CarrinhoCompras {
    void adicionarItem(Produto produto, int quantidade);
    double calcularTotal();
    void limparCarrinho();
	List<ItemCarrinho> getItens();
	void exibirItens();
}
