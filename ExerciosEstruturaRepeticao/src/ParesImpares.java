/*
 3 . Escreva um código que o usuário entre com um primeiro número, um segundo número maior que o primeiro
 e escolha entre a opção par e impar, com isso o código deve informar todos os núemros pares ou ímpares 
 (de acordo com a seleção inicial) no intervalo de números informados, incluindo os números informados
 e em ordem descrecente
 */

import java.util.Scanner;

public class ParesImpares {
    public static void numeros(Scanner sc) {

        int primeiroNumero = 0;
        int segundoNumero = 0;

        //validando a numero
         do {
         try { 
           System.out.print("\nDigite o primeiro número: ");
           primeiroNumero = sc.nextInt();
           sc.nextLine();

           if(primeiroNumero <= 0) {
              throw new Exception("O número não pode ser menor ou igual a zero");
           }

         } catch(Exception e) {
           System.out.println("\n####################################################");
           System.out.println("Erro: " + (e.getMessage() != null ? e.getMessage() : "Entrada inválida"));
           System.out.println("####################################################");
           System.out.println("\n Tente novamente!!!");
           primeiroNumero = 0;
           sc.nextLine();
         
         }
       } while(primeiroNumero <= 0);

       //validando segundo número
       //validando a numero
         do {
         try { 
           System.out.print("\nDigite o segundo número: ");
           segundoNumero = sc.nextInt();
           sc.nextLine();

           if(segundoNumero <= primeiroNumero) {
              throw new Exception("O segundo número deve ser maior que o primeiro");
           }

         } catch(Exception e) {
           System.out.println("\n####################################################");
           System.out.println("Erro: " + (e.getMessage() != null ? e.getMessage() : "Entrada inválida"));
           System.out.println("####################################################");
           System.out.println("\n Tente novamente!!!");
           segundoNumero = 0;
           sc.nextLine();
         
         }
       } while(segundoNumero <= primeiroNumero);

       System.out.println("\nEscola a opção abaixo:  ");
       System.out.println("\n 1-  Exibir pares");
       System.out.println(" 2 - Exibir ímapares");
       System.out.println();
       int escolha = 0;

       final int PARES = 1;
       final int IMPARES = 2;
    
       do {
          try {
            escolha = sc.nextInt();
            switch (escolha) {
            case PARES:
                System.out.println("\n==== EXIBINDO PARES ===");
                pares(primeiroNumero, segundoNumero);
                break;
            case IMPARES:
                System.out.println("\n==== EXIBINDO IMPARES ===");
                imapares(primeiroNumero, segundoNumero);
                break;

        
            default:
                System.out.println("Digite corretamente");
                break;
            }         
            
            if(escolha != PARES && escolha != IMPARES) 
                throw new Exception("Escolha a opção corretamente!!!");

        } catch(Exception e) {
            System.out.println("\n####################################################");
            System.out.println("Erro: " + (e.getMessage() != null ? e.getMessage() : "Entrada inválida"));
            System.out.println("####################################################");
            System.out.println("\n Tente novamente!!!");
            escolha = 0;
            sc.nextLine();
         }
 
      } while(escolha != PARES && escolha != IMPARES);
       
    }

    public static void pares(int primeiroNumero, int segundoNumero) {
        for(int i = segundoNumero; i >= primeiroNumero; i--) {
            if(i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void imapares(int primeiroNumero, int segundoNumero) {
        for(int i = segundoNumero; i >= primeiroNumero; i--) {
            if(i % 2 != 0) {
                System.out.println(i);
            }
        }
    }


 
}
