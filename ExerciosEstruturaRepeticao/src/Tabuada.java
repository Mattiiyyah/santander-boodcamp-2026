/* 1 - Escreva um código onde o usuário entra com um número 
   e seja gerada a tabuada de 1 até 10 desse número
*/

import java.util.Scanner;

public class Tabuada {
  public static void tabuada(Scanner sc) {
      System.out.println("============== Exercício 1 =========");
      
      final int DEZ = 10;

      int numero = 0;
      int resultado = 0;
      System.out.print("Escreva um número Inteiro Qualquer: ");
      numero = sc.nextInt();

      for(int i = 1; i <= DEZ; i++) {
         resultado = numero * i;
         System.out.printf("%s X %s = %s \n", numero, i, resultado);
      }
     
  }
}
