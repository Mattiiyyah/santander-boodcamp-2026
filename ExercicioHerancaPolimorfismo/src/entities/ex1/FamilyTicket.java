package entities.ex1;

import java.util.Scanner;

public final class FamilyTicket extends Ticket {

    private int quantityOfPeople;

    public FamilyTicket(Double value, String nameMovie, boolean status) {
        super(value, nameMovie, status);
    }

    public void validationPerson(Scanner sc) {
       int person = 0;
       do {
         try { 
            System.out.println("\nDigite a quantidade de pessoas: ");
            person = sc.nextInt();

            if(person <= 0) {
                throw new Exception("[ ! ] Digite uma quantidade correta de pessoas");
            }

         } catch(Exception e) {
            System.out.println("\n------------------------------");
            System.out.println("\nErro: " + e.getMessage());
            System.out.println("\n------------------------------");
            person = 0;
            sc.nextLine();
         }

       } while(person <= 0);

       this.quantityOfPeople = person;
    }

    public int getQuantityOfPeople() {
        return quantityOfPeople;
    }

    @Override
    public double ticketValue() {
        double totalValue = getValue() * quantityOfPeople; 
        
        if(quantityOfPeople > 3) {
            totalValue -= totalValue * 0.05;
        }

        return totalValue;
    }

}
