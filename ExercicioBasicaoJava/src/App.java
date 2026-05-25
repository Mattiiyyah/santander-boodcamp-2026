import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/***
 * 1 - Escreva um código que receba o nome ano de nascimento de alguém e imprima
 * na tela a seguinte mensagem: "Olá Fulano", você tem 'X' anos.
 * 
 * 2 - Escreva um código que receba o tamanho do lado de um quadrado, calcule
 * sua área e exiba na tela a fórmula: área = lado x lado
 * 
 * 3 - Escreva um código que receba a base e a altura de um retângulo, calcule sua área e exbiba na tela
 * fórmula: área = base x altura
 * 
 * 4 - Escreva um código que receba o nome e a idade de 2 pessoas e imprima na tela a diferente de idade entre elas
 * 
 */

public class App {

   // Constantes para o menu
   private static final int EXERCICIO_PESSOA = 1;
   private static final int EXERCICIO_QUADRADO = 2;
   private static final int EXERCICIO_RETANGULO = 3;
   private static final int EXERCICIO_DIFERENCA_IDADE = 4;
   private static final int SAIR = 0;

   public static void main(String[] args) {
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);
      
      int opcao = -1;

      while (opcao != SAIR) {
          System.out.println("\n\n============== MENU DE EXERCÍCIOS ==============");
          System.out.println(EXERCICIO_PESSOA + " - Idade da pessoa (Ex 1)");
          System.out.println(EXERCICIO_QUADRADO + " - Área do quadrado (Ex 2)");
          System.out.println(EXERCICIO_RETANGULO + " - Área do retângulo (Ex 3)");
          System.out.println(EXERCICIO_DIFERENCA_IDADE + " - Diferença de idade (Ex 4)");
          System.out.println(SAIR + " - Sair");
          System.out.print("Escolha uma opção: ");

          try {
              opcao = sc.nextInt();
              sc.nextLine(); 

              switch (opcao) {
                  case EXERCICIO_PESSOA:
                      Exercicios.pessoa(sc);
                      break;
                  case EXERCICIO_QUADRADO:
                      Exercicios.quadrado(sc);
                      break;
                  case EXERCICIO_RETANGULO:
                      Exercicios.retangulo(sc);
                      break;
                  case EXERCICIO_DIFERENCA_IDADE:
                      Exercicios.pessoas(sc);
                      break;
                  case SAIR:
                      System.out.println("\nSaindo do programa... Até logo!");
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
