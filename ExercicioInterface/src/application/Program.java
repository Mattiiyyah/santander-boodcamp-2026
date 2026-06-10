package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    private static final int EXERCICIO_MESSAGE   =  1;
    private static final int EXERCICIO_PRODUCTS  =  2;
    private static final int EXERCICIO_SHAPE     =  3;
    private static final int EXIT                =  0;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int opcao = -1;

        while(opcao != EXIT) {
            System.out.println("\n\n============== MENU DE EXERCÍCIOS ==============");
            System.out.println(EXERCICIO_MESSAGE + " Consultar exercício Mensagens");
            System.out.println(EXERCICIO_PRODUCTS + " Consultar exercício Produtos");
            System.out.println(EXERCICIO_SHAPE + " Consultar exercício Figuras");
            System.out.println(EXIT + " - Sair");
            System.out.print("\nEscolha uma opção: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case EXERCICIO_MESSAGE:
                        MenuMensagens.exibirMenu(sc);
                        break;
                    case EXERCICIO_PRODUCTS:
                        MenuProducts.exibirMenu(sc);
                        break;
                    case EXERCICIO_SHAPE:
                        MenuShape.exibirMenu(sc);
                        break;
                    case EXIT: 
                        System.out.println("\nSaindo.....");
                        break;
                    default:
                        System.out.println("\n[!] Opção inválida. Escolha um número do menu.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[!] Erro: Digite apenas números inteiros para a opção do menu.");
                sc.nextLine();
            }

        }

        sc.close();
    }
}
