package application;

import java.util.Scanner;

import entities.Pet;
import entities.PetMachine;

public class PetMenu {

    private final PetMachine petMachine = new PetMachine();

    public void executar(Scanner sc) {
        
        Scanner leitor = sc;
        
        int opcao = -1;

        do {
            System.out.println("\n=== Escolha uma das opções ===");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer a máquina com água");
            System.out.println("3 - Abastecer a máquina com shampoo");
            System.out.println("4 - Verificar água da máquina");
            System.out.println("5 - Verificar shampoo da máquina");
            System.out.println("6 - Verificar se tem pet na máquina");
            System.out.println("7 - Colocar pet na máquina");
            System.out.println("8 - Retirar pet da máquina");
            System.out.println("9 - Limpar a máquina");
            System.out.println("0 - Sair");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1: 
                   petMachine.darBanhoPet();
                   break;
                case 2: 
                   colocarAgua();
                   break;
                case 3: 
                   colocarShampoo();
                   break;
                case 4: 
                    verificarAgua();
                    break;
                case 5:
                    verificarShampoo();
                    break;
                case 6: 
                   checarSetemPetNaMaquina();
                   break;
                case 7:
                   setPetDetroMaquina(leitor); 
                   break;
                case 8:
                    petMachine.removerPet();
                    break;
                case 9: 
                    petMachine.limparMaquina();
                    break;
                case 0: 
                   System.exit(0);
                default:
                    System.out.println("\nOpção inválida");
                    break;
            }
        } while(true);
    }

    private void colocarAgua() {
        System.out.println("\nTentando colocar água dentro da máquina");
        petMachine.addAgua();
    }

    private void colocarShampoo() {
        System.out.println("\nTentando colocar shampoo dentro da máquina");
        petMachine.addShampoo();
    }
   
    private void verificarAgua() {
        int quantidade = petMachine.getAgua();
        System.out.println("\nA máquina está no momento com " + quantidade + " litros(s) de água");

    }

    private void verificarShampoo() {
        int quantidade = petMachine.getShampoo();
        System.out.println("\nA máquina está no momento com " + quantidade + " litros(s) de shampoo");
    }

    private void checarSetemPetNaMaquina() {
        boolean temPet = petMachine.temPet();
        System.out.println(temPet ? "\nTem pet na máquina" : "\nNão tem pet na máquina");
    }

    private void setPetDetroMaquina(Scanner leitor) {
        String nome = "";

        System.out.print("\nInforme o nome do pet: ");
        while (nome == null || nome.isEmpty()) {
            nome = leitor.nextLine();
        }
        
        Pet pet = new Pet(nome);
        petMachine.setPet(pet);
    }
}
