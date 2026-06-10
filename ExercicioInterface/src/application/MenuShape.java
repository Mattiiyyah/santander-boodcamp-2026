package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import ex3.Circle;
import ex3.Rectangle;
import ex3.Square;

public abstract class MenuShape {
    private static final  int SQUARE        = 1;
    private static final  int RECTANGLE     = 2;
    private static final  int CIRCLE        = 3;
    private static final  int EXIT          = 0;

    public static void exibirMenu(Scanner sc) {

        int opcao = -1;

        while(opcao != EXIT) {

            System.out.println("\n\n========== EXERCICIO 3 ==============");
            System.out.println("\nEscolha uma opção abaixo:   ");
            System.out.println(SQUARE       + " - consultar area do quadrado");
            System.out.println(RECTANGLE    + " - consultar area do retangulo");
            System.out.println(CIRCLE       + " - consultar area do circulo");
            System.out.println(EXIT         + " - SAIR");

            try {
                
                opcao = sc.nextInt();
                sc.nextLine(); 

                switch (opcao) {
                    case SQUARE:
                        int side = validarNumero(sc, "\nDigite o lado do quadrado: ");
                        Square square = new Square(side);
                        square.area();
                        break;
                    case RECTANGLE:
                        int lenght = validarNumero(sc, "\nDigite a largura do retangulo: ");
                        int height = validarNumero(sc, "\nDigite a altura do retangulo: ");
                        Rectangle rectangle = new Rectangle(lenght, height);
                        rectangle.area();
                        break;
                    case CIRCLE:
                        int radius = validarNumero(sc, "\nDigite o raio do circulo: ");
                        Circle circle = new Circle(radius);
                        circle.area();
                        break;
                    case EXIT:
                        System.out.println("\nSaindo do exercicio 3");
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

    public static int validarNumero(Scanner sc, String message) {
        int number = 0;
        boolean isValid = false;

        do {
            try {
                System.out.println(message);
                number = sc.nextInt();

                if (number <= 0) {
                    throw new Exception("[!] o numero deve ser maior que zero!");
                }

                isValid = true;

            } catch(InputMismatchException e) {
                System.out.println("\nValor inválido! Por favor, digite um número válido.");
                sc.nextLine();
                number = 0;
            } catch(Exception e) {
                System.out.println("\nErro: " + e.getMessage());
            }
        } while(!isValid);
        
        return number;
    }
}
