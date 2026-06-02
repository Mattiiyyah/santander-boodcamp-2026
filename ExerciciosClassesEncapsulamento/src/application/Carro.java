package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.FuncionalidadesCarro;

public class Carro {

    private static final int LIGAR              = 1;
    private static final int DESLIGAR           = 2;
    private static final int ACELERAR           = 3;
    private static final int DIMINUIR           = 4;
    private static final int TROCAR_MARCHA      = 5;
    private static final int VIRAR              = 6;
    private static final int VER_VELOCIDADE     = 7;
    private static final int SAIR               = 0;

    public void executar(Scanner sc) {

        FuncionalidadesCarro carro = new FuncionalidadesCarro();
        System.out.println("\nCarro criado! Status: desligado | Marcha: 0 | Velocidade: 0km/h");

        int opcao = -1;

        while (opcao != SAIR) {
            System.out.println("\n\n============== MENU DO CARRO ==============");
            System.out.println(LIGAR          + " - Ligar o carro");
            System.out.println(DESLIGAR       + " - Desligar o carro");
            System.out.println(ACELERAR       + " - Acelerar");
            System.out.println(DIMINUIR       + " - Diminuir velocidade");
            System.out.println(TROCAR_MARCHA  + " - Trocar marcha");
            System.out.println(VIRAR          + " - Virar (esquerda/direita)");
            System.out.println(VER_VELOCIDADE + " - Verificar velocidade");
            System.out.println(SAIR           + " - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case LIGAR:
                        carro.ligarCarro();
                        break;

                    case DESLIGAR:
                        carro.desligarCarro();
                        break;

                    case ACELERAR:
                        carro.acelerar();
                        break;

                    case DIMINUIR:
                        carro.diminuir();
                        break;

                    case TROCAR_MARCHA:
                        int novaMarcha = lerInteiro(sc, "Digite a marcha desejada (0 a 6): ");
                        carro.trocarMarcha(novaMarcha);
                        break;

                    case VIRAR:
                        System.out.print("\nDigite a direção (esquerda/direita): ");
                        String direcao = sc.nextLine().trim();
                        carro.virarCarro(direcao);
                        break;

                    case VER_VELOCIDADE:
                        carro.verificarVelocidade();
                        break;

                    case SAIR:
                        System.out.println("\nSaindo do menu do carro... Até logo!");
                        break;

                    default:
                        System.out.println("\n[!] Opção inválida. Escolha um número do menu.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Digite apenas números inteiros para a opção do menu.");
                System.out.println("####################################################");
                sc.nextLine();
            }
        }
    }

    // Lê um inteiro do usuário com validação
    private int lerInteiro(Scanner sc, String mensagem) {
        int valor = -1;

        do {
            try {
                System.out.print(mensagem);
                valor = sc.nextInt();
                sc.nextLine();

                if (valor < 0 || valor > 6) {
                    throw new Exception("Informe um valor entre 0 e 6.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Digite apenas números inteiros.");
                System.out.println("####################################################");
                System.out.println("\nTente novamente!!!");
                valor = -1;
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("\n####################################################");
                System.out.println("Erro: " + e.getMessage());
                System.out.println("####################################################");
                System.out.println("\nTente novamente!!!");
                valor = -1;
            }
        } while (valor < 0);

        return valor;
    }
}
