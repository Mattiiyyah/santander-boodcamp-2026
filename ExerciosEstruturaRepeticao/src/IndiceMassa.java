/* 2 - Escreva um código onde o usuário entra com sua altura e peso, seja feito o cálculo do seu IMC(IMC = peso / (altura * altura)) 
  e seja exibida a mensagem de acordo com o resultado:
  
  . Se for menor ou igual a 18,5 "Abaixo do peso";
  . Se for entre 18.6 e 24.9 "Peso ideal";
  . Se for entre 25,0 e 29,9 "Levemente acima do peso";
  . Se for entre 30,0 e 34,9 "Obesidade Grau I";
  . Se for entre 35,0 e 39,9 "Obesidade Grau II (Severa)";
  . Se for maior que 40,0 "Obesidade III (Mórbida)";

*/

import java.util.Scanner;

public class IndiceMassa {
   public static void imc(Scanner sc) {

        final double V1 = 18.5;
        final double V2 = 24.9;
        final double V3 = 29.9;
        final double V4 = 34.9;
        final double V5 = 39.9;

        double altura = 0.0;
        double peso = 0.0;
        double imc;

        String mensagem = "";

        //validando a altura
         do {
         try { 
           System.out.print("\nDigite a sua altura: ");
           altura = sc.nextDouble();
           sc.nextLine();

           if(altura <= 0) {
              throw new Exception("A altura não pode ser menor ou igual a zero");
           }

         } catch(Exception e) {
           System.out.println("\n####################################################");
           System.out.println("Erro: " + (e.getMessage() != null ? e.getMessage() : "Entrada inválida"));
           System.out.println("####################################################");
           System.out.println("\n Tente novamente!!!");
           altura = 0.0;
           sc.nextLine();
         
         }
       } while(altura <= 0.0);

       //validando o peso

       do {
         try { 
           System.out.print("\nDigite o seu peso: ");
           peso = sc.nextDouble();
           sc.nextLine();

           if(peso <= 0) {
              throw new Exception("O peso não pode ser menor ou igual a zero");
           }

         } catch(Exception e) {
           System.out.println("\n####################################################");
           System.out.println("Erro: " + (e.getMessage() != null ? e.getMessage() : "Entrada inválida"));
           System.out.println("####################################################");
           System.out.println("\n Tente novamente!!!");
           peso = 0.0;
           sc.nextLine();
         
         }
       } while(peso <= 0.0);

       imc = peso / (altura * altura);

       if(imc <= V1) 
          mensagem = "Abaixo do peso";
        else if(imc > V1 && imc <= V2)
          mensagem = "Peso ideal";
        else if(imc > V2 && imc <= V3)
          mensagem = "Levemente acima do peso";
        else if(imc > V3 && imc <= V4)
          mensagem = "Obesidade Grau I";
        else if(imc > V4 && imc <= V5)
          mensagem = "Obesidade Grau II (Severa)";
        else 
          mensagem = "Obesidade III (Mórbida)";

        System.out.println("\n" + mensagem);
       
    }
}
