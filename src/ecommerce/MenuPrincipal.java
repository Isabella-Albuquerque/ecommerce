package ecommerce;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        int opcao;

        while (true) {
            exibirMenu();

            opcao = leia.nextInt();

            if (opcao == 4) {
                System.out.println("\n  Agradecemos seu interesse em nossos produtos! Volte sempre!");
                sobre();
                leia.close();
                break; 
            }

            switch (opcao) {
                case 1:
                    System.out.println("  Ver Produtos");
                    break;
                case 2:
                    System.out.println("  Carrinho\n\n");
                    break;
                case 3:
                    System.out.println("  Finalizar minha compra\n\n");
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
}
