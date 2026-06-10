package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import ex2.Clothing;
import ex2.Culture;
import ex2.Food;
import ex2.Health;

public abstract class MenuProducts {
    
    private static final int FOOD     =  1;
    private static final int HEALTH   =  2;
    private static final int CLOTHING =  3;
    private static final int CULTURE  =  4;
    private static final int EXIT     =  0;

    public static void exibirMenu(Scanner sc) {

        int opcao = -1; 

        while(opcao != EXIT) {
            System.out.println("\n\n========== EXERCICIO 2 ==============");
            System.out.println("\nEscolha uma opção abaixo:   ");
            System.out.println(FOOD       + " - consultar valor de taxa ALIMENTACAO");
            System.out.println(HEALTH     + " - consultar valor de taxa SAUDE");
            System.out.println(CLOTHING   + " - consultar valor de taxa VESTUARIO");
            System.out.println(CULTURE    + " - consultar valor de taxa CULTURA");
            System.out.println(EXIT       + " - SAIR");

            try {
                
                opcao = sc.nextInt();
                sc.nextLine();


                switch (opcao) {
                    case FOOD:
                        Food food = new Food(validarValor(sc));
                        food.taxAmount();
                        break;
                    case HEALTH:
                        Health health = new Health(validarValor(sc));
                        health.taxAmount();
                        break;
                    case CLOTHING:
                        Clothing clothing = new Clothing(validarValor(sc));
                        clothing.taxAmount();
                        break;
                    case CULTURE:
                        Culture culture = new Culture(validarValor(sc));
                        culture.taxAmount();
                        break;
                    case EXIT:
                        System.out.println("\nSaindo do exercício 2");
                        break;
                    default:
                        System.out.println("\n[!] Opção inválida no menu de mensagens.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[!] Erro: Digite apenas números inteiros para a opção do menu.");
                sc.nextLine();
            }
        } 
    }

    private static double validarValor(Scanner sc) {
        double amount = 0.0;
        boolean isValid = false;

        do {
           try {
                System.out.println("\nDigite o valor: ");
                amount = sc.nextDouble();
                
                if (amount <= 0) {
                    throw new Exception("O valor deve ser maior que zero!");
                } 
                
                isValid = true;
           } catch(InputMismatchException e) {
                System.out.println("\nValor inválido! Por favor, digite um número válido.");
                sc.nextLine();
                amount = -1.0;
           } catch(Exception e) {
                System.out.println("\nErro:" + e.getMessage());
                sc.nextLine();
                amount = -1.0;
           }
        } while (!isValid);
        
        return amount;
    }

}
