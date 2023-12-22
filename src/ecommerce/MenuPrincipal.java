package ecommerce;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ecommerce.model.Produto;
import ecommerce.model.Fruta;
import ecommerce.model.ItemCarrinho;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        Produtos produtos = new Produtos();
        Carrinho carrinho = new Carrinho();

        int opcao;

        while (true) {
            exibirMenu();

          //Tratamento de exceções
            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro: entrada inválida. Insira um número do menu.");
                leia.next(); 
                continue; 
            }

            if (opcao == 4) {
                System.out.println("\nAgradecemos seu interesse em nossos produtos! Volte sempre!");
                sobre();
                leia.close();
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Ver Produtos");
                    exibirProdutos(produtos.getListaProdutos());
                    adicionarProdutosAoCarrinho(leia, produtos, carrinho);
                    break;
                case 2:
                    System.out.println("Carrinho\n");
                    exibirCarrinho(carrinho);
                    break;
                case 3:
                    System.out.println("Finalizar minha compra\n");
                    finalizarCompra(leia, carrinho);
                    break;
                default:
                    System.out.println("\nOpção Inválida!\n");
                    break;
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("*****************************************************");
        System.out.println("                                                     ");
        System.out.println("               HORTIFRUTI ONLINE                     ");
        System.out.println("                                                     ");
        System.out.println("*****************************************************");
        System.out.println("                                                     ");
        System.out.println("            1 - Ver Produtos                         ");
        System.out.println("            2 - Carrinho                             ");
        System.out.println("            3 - Finalizar Compra                     ");
        System.out.println("            4 - Sair                                 ");
        System.out.println("*****************************************************");
        System.out.println("\n\n Insira a opção desejada:                        ");
        System.out.println("                                                     ");
    }

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: ");
        System.out.println("Isabella de Paula Albuquerque");
        System.out.println("*********************************************************");
    }

    public static void exibirProdutos(List<Produto> produtos) {
        System.out.println("\nLista de Produtos Disponíveis:");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
        System.out.println();
    }

    private static void adicionarProdutosAoCarrinho(Scanner leia, Produtos produtos, Carrinho carrinho) {
        System.out.println("Digite o ID do produto que deseja adicionar ao carrinho\n Para finalizar adição de produtos digite 0 ");
        int idProduto = leia.nextInt();

        while (idProduto != 0) {
            Produto produtoSelecionado = produtos.encontrarProdutoPorId(idProduto);

            if (produtoSelecionado != null) {
                System.out.println("Digite a quantidade desejada: ");
                int quantidade = leia.nextInt();

                if (quantidade > 0) {
                    carrinho.adicionarItem(produtoSelecionado, quantidade);
                    System.out.println("Produto adicionado ao carrinho!");

                    if (produtoSelecionado instanceof Fruta) {
                        Fruta fruta = (Fruta) produtoSelecionado;
                        System.out.println("Tipo de Fruta: " + fruta.getTipo());
                    }
                } else {
                    System.out.println("Quantidade inválida. Tente novamente.");
                }
            } else {
                System.out.println("Produto não encontrado. Tente novamente.");
            }

            System.out.println("Digite o ID do próximo produto (ou 0 para encerrar a adição de produtos): ");
            idProduto = leia.nextInt();
        }

        System.out.println("Você finalizou a adição de produtos. Para concluir a compra, escolha a opção 3.");
    }

    private static void exibirCarrinho(Carrinho carrinho) {
        List<ItemCarrinho> itens = carrinho.getItens();

        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio.");
        } else {
            for (ItemCarrinho item : itens) {
                System.out.println(item);
            }
            System.out.println("Total do Carrinho: R$ " + carrinho.calcularTotal());
        }

        System.out.println();
    }

    private static void finalizarCompra(Scanner leia, Carrinho carrinho) {
        exibirCarrinho(carrinho);

        System.out.println("Preencha os dados para finalizar sua compra:\nInsira seu nome: ");
        String nomeCliente = leia.next();

        System.out.println("Insira seu email: ");
        String emailCliente = leia.next();

        System.out.println("Insira seu endereço: ");
        String enderecoCliente = leia.next();

        System.out.println("\n COMPRA FINALIZADA COM SUCESSO!\nInformações da Compra:");
        System.out.println("Nome comprador: " + nomeCliente);
        System.out.println("E-mail: " + emailCliente);
        System.out.println("Endereço de entrega: " + enderecoCliente);

        System.out.println("\nTotal do Carrinho: R$ " + carrinho.calcularTotal());
        System.out.println(" O código de pagamento PIX é: " + gerarCodigoPix());
        System.out.println("Obrigada por comprar conosco!! :D  \n\n ");

        carrinho.limparCarrinho(); //para limpar o carrinho quando a compra é finalizada
    }

    private static String gerarCodigoPix() { //para gerar um numero aleatório simulando um código PIX
        return String.valueOf((int) (Math.random() * 100000));
    }
}
