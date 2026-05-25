import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Exercicios {

   //primeiro exercício
   public static void pessoa(Scanner sc) {
      System.out.println("============== EXERCÍCIO 1 ============== ");
      String nome = "";
      String dataNascimento = "";
      int idade = 0;

      //validando Nome
      do {
         try {
            System.out.print("\nDigite o seu nome: ");
            nome = sc.nextLine();

           if(nome.isBlank()) {
              throw new Exception("O nome não pode ser vazio");
           }

           if(nome.length() < 5) {
             nome = "";
             throw new Exception("O nome deve conter mais de 5 caracteres");
           }

         } catch(Exception e) {
           System.out.println("\n####################################################");
           System.out.println("Erro: " + e.getMessage());
           System.out.println("####################################################");
           System.out.println("\n Tente novamente!!!");
         }
       } while(nome == null || nome.isBlank() || nome.length() < 5);

      //validação para o ano de nascimento

      boolean dataValida = false;

      do {
         try {
            System.out.print("\nDigite sua data de nascimento: ");
            dataNascimento = sc.nextLine();
            LocalDate dataNascimentoFormatada = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            LocalDate dataAtual = LocalDate.now();

            Period periodo = Period.between(dataNascimentoFormatada, dataAtual);
            idade = periodo.getYears();

            dataValida = true;

         } catch(DateTimeParseException e) {
            System.out.println("\n####################################################");
            System.out.println("Erro: Formato inválido. Use dd/MM/yyyy (ex: 25/12/2025)");
            System.out.println("####################################################");
            System.out.println("\n Tente novamente!!!");
         }
      } while(!dataValida);
   
      System.out.printf("Olá %s você tem %s", nome, idade);

   }
   
   public static void quadrado(Scanner sc) {
      System.out.println("\n============== EXERCÍCIO 2 ============== ");
      double ladoQuadrado = 0.0;
      double area = 0.0;

       //validando ID
      do {
         try { 
           System.out.print("\nDigite o lado do quadrado: ");
           ladoQuadrado = sc.nextDouble();
           sc.nextLine();

           if(ladoQuadrado == 0.0) {
              throw new Exception("O código não pode ser menor ou igual a zero");
           }

         } catch(Exception e) {
           System.out.println("\n####################################################");
           System.out.println("Erro: " + e.getMessage());
           System.out.println("####################################################");
           System.out.println("\n Tente novamente!!!");
           ladoQuadrado = 0.0;
           sc.nextLine();
         }
       } while(ladoQuadrado == 0.0);

       area = Math.pow(ladoQuadrado, 2);
       
       System.out.printf("A área do quadrado é: %.2f", area);
       
   }

   public static void retangulo(Scanner sc) {
      System.out.println("\n============== EXERCÍCIO 3 ============== ");
      double base = 0;
      double altura = 0;

      // validando a base
      do {
         try { 
           System.out.print("\nDigite a base do retângulo: ");
           base = sc.nextDouble();
           sc.nextLine();

           if(base <= 0) {
              throw new Exception("A base não pode ser menor ou igual a zero");
           }

         } catch(Exception e) {
           System.out.println("\n####################################################");
           System.out.println("Erro: " + (e.getMessage() != null ? e.getMessage() : "Entrada inválida"));
           System.out.println("####################################################");
           System.out.println("\n Tente novamente!!!");
           base = 0;
           sc.nextLine();
         }
       } while(base <= 0);

      // validando a altura
      do {
         try { 
           System.out.print("\nDigite a altura do retângulo: ");
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
           altura = 0;
           sc.nextLine();
         
         }
       } while(altura <= 0);

       double area = base * altura;
       
       System.out.printf("A área do retângulo é: %.2f", area);
   }

   public static void pessoas(Scanner sc) {
      System.out.println("\n============== EXERCÍCIO 4 ============== ");
      String[] nomes = new String[2];
      int[] idades = new int[2];

      String nome = "";
      int idade = 0;

      for(int i = 0; i < 2; i++) {
        System.out.println("--- Digitando dados da Pessoa " + (i + 1) + " ---");
        //validando Nome
        do {
         try {
            System.out.print("\nDigite o seu nome: ");
            nome = sc.nextLine();

           if(nome.isBlank()) {
              throw new Exception("O nome não pode ser vazio");
           }

           if(nome.length() < 5) {
             nome = "";
             throw new Exception("O nome deve conter mais de 5 caracteres");
           }

         } catch(Exception e) {
           System.out.println("\n####################################################");
           System.out.println("Erro: " + e.getMessage());
           System.out.println("####################################################");
           System.out.println("\n Tente novamente!!!");
         }
       } while(nome == null || nome.isBlank() || nome.length() < 5);
        
        nomes[i] = nome;
        
        //validacao para idade
        do {
         try { 
           System.out.print("\nDigite a idade de " + nome + ": ");
           idade = sc.nextInt();
           sc.nextLine();

           if(idade <= 0) {
              throw new Exception("A idade não pode ser menor ou igual a zero");
           }

           if(idade >= 120) {
              throw new Exception("Insira uma idade até 119 anos");
           } 

         } catch(Exception e) {
           System.out.println("\n####################################################");
           System.out.println("Erro: " + (e.getMessage() != null ? e.getMessage() : "Entrada inválida"));
           System.out.println("####################################################");
           System.out.println("\n Tente novamente!!!");
           idade = 0;
           sc.nextLine();
         
         }
       } while(idade <= 0);

        idades[i] = idade;
      }

      int diferencaIdade = Math.abs(idades[0] - idades[1]);

      System.out.printf("A diferença de idade é: %s", diferencaIdade);

   }

}
