package entities.ex2;

import java.util.Scanner;

public final class Attendant extends Employee {

    private final Scanner sc = new Scanner(System.in);
    private double cashValue; 

    public Attendant(String name, String email, String password) {
        super(name, email, password, false);
        this.cashValue = 0.0; 
    }

    public double getCashValue() {
        return cashValue;
    }

    public void setCashValue(double cashValue) {
        this.cashValue = cashValue;
    }

    //adicionando valor ao caixa
    public void receivePayment(double amount) {
        if (amount > 0) {
            this.cashValue += amount;
            System.out.println("\n=== PAGAMENTO RECEBIDO ===");
            System.out.printf("Valor recebido: R$ %.2f\n", amount);
            System.out.printf("Novo valor em caixa: R$ %.2f\n", this.cashValue);
            System.out.println("==========================");
        } else {
            System.out.println("Valor inválido para pagamento.");
        }
    }

    // Fechar o caixa
    public void closeRegister() {
        System.out.println("\n=== FECHAMENTO DE CAIXA ===");
        System.out.printf("Fechando o caixa com valor total de: R$ %.2f\n", this.cashValue);
        this.cashValue = 0.0;
        System.out.println("Caixa fechado e zerado com sucesso!");
        System.out.println("===========================");
    }

    @Override
    public void login() {
        System.out.println("\n\n==== REALIZANDO LOGIN (ATENDENTE) ====");
        System.out.println("Nome: "   + super.getName());
        System.out.println("E-mail: " + super.getEmail());
        System.out.println("Senha: "  + super.getPassword());
        System.out.println("Admin: "  + super.getAdmin());
    }

    @Override
    public void logff() {
        System.out.println("\n\n==== SAINDO DA CONTA (ATENDENTE) ====");
        System.out.println("Nome: "   + super.getName());
        System.out.println("E-mail: " + super.getEmail());
        System.out.println("Senha: "  + super.getPassword());
        System.out.println("Admin: "  + super.getAdmin());
    }

    @Override
    public void editProfile() {
        System.out.println("\n\n==== EDITANDO PERFIL (ATENDENTE) ====");
        
        String name, email;
        System.out.print("Editando nome: ");
        name = sc.nextLine();

        System.out.print("Editando e-mail: ");
        email = sc.next();

        super.setName(name);
        super.setEmail(email);
    }

    @Override
    public void changePassword() {
        System.out.println("\n\n==== EDITANDO SENHA (ATENDENTE) ====");
        String password;

        System.out.print("Editando senha: ");
        password = sc.next();

        super.setPassword(password);
    }
}
