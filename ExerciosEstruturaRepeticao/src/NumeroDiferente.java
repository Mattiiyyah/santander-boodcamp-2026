/**
    4 . Escreva um código onde o usuário informa um número inicial,
    posteriormente irá informar outros N números, a execução do código irá
    continuar até que o número informado divido pelo primeiro número tenha resto diferente de 0 na divisão,
    números menores que o primeiro número devem ser ignorados
 */


import java.util.Scanner;

public class NumeroDiferente {
   public static void numeros(Scanner sc) {
        
        int primeiroNumero = 0;

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

       //loop principal: continua até receber número não divisível pelo primeiro
       int numero = 0;
       boolean continuar = true;

       do {
         try {
           System.out.print("\nDigite um número: ");
           numero = sc.nextInt();
           sc.nextLine();

           if(numero < primeiroNumero) {
              System.out.println("Número ignorado (menor que o primeiro número).");
              continue;
           }

           if(numero % primeiroNumero != 0) {
              System.out.println("Encerrando: " + numero + " não é divisível por " + primeiroNumero + ".");
              continuar = false;
           } else {
              System.out.println(numero + " é divisível por " + primeiroNumero + ". Continue digitando...");
           }

         } catch(Exception e) {
           System.out.println("\n####################################################");
           System.out.println("Erro: " + (e.getMessage() != null ? e.getMessage() : "Entrada inválida"));
           System.out.println("####################################################");
           System.out.println("\n Tente novamente!!!");
           sc.nextLine();
         
         }
       } while(continuar);
   }
}
