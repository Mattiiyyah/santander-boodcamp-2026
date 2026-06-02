package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

   private static final int EXERCICIO_BANCO = 1;
   private static final int EXERCICIO_CARRO = 2;
   private static final int EXERCICIO_PET = 3;
   private static final int SAIR = 0;

   public static void main(String[] args) {
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);

      int opcao = -1;

      while (opcao != SAIR) {
         System.out.println("\n\n============== MENU DE EXERCÍCIOS ==============");
         System.out.println(EXERCICIO_BANCO + " Consultar exercício Banco");
         System.out.println(EXERCICIO_CARRO + " Consultar exercício Carro");
         System.out.println(EXERCICIO_PET + " Consultar exercício Pet");
         System.out.println(SAIR + " - Sair");
         System.out.print("Escolha uma opção: ");

         try {
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
               case EXERCICIO_BANCO:
                  System.out.println("\n========== EXERCÍCIO 1: BANCO ==========");
                  new Banco().executar(sc);
                  break;
               case EXERCICIO_CARRO:
                  System.out.println("\n========== EXERCÍCIO 2: CARRO ==========");
                  new Carro().executar(sc);
                  break;
               case EXERCICIO_PET:
                  System.out.println("\n========== EXERCÍCIO 3: PET ==========");
                  new PetMenu().executar(sc);
                  break;
               default:
                  System.out.println("\n[!] Opção inválida. Escolha um número do menu.");
            }
         } catch (InputMismatchException e) {
            System.out.println("\n[!] Erro: Digite apenas números inteiros para a opção do menu.");
            sc.nextLine();
         }
      }

      System.out.println("\n========== EXERCÍCIO 3: PET ==========");
      new PetMenu().executar(sc);

      sc.close();
   }
}
