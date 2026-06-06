package entities.ex2;

import java.util.Scanner;

public final class Salesperson extends Employee {

    private final Scanner sc = new Scanner(System.in);
    private int quantityOfSales;

    public Salesperson(String name, String email, String password) {
        super(name, email, password, false);
        this.quantityOfSales = 0;
    }

    public int getQuantityOfSales() {
        return quantityOfSales;
    }

    public void setQuantityOfSales(int quantityOfSales) {
        this.quantityOfSales = quantityOfSales;
    }

    // Realizar venda (incrementar o número de vendas quando acionado)
    public void registerSale() {
        this.quantityOfSales++;
        System.out.println("\n=== NOVA VENDA REALIZADA ===");
        System.out.println("Vendedor: " + super.getName());
        System.out.println("Total de vendas agora: " + this.quantityOfSales);
        System.out.println("============================");
    }

    // Consultar vendas
    public void consultSales() {
        System.out.println("\n=== CONSULTA DE VENDAS ===");
        System.out.println("Você realizou um total de " + this.quantityOfSales + " vendas.");
        System.out.println("==========================");
    }

    @Override
    public void login() {
        System.out.println("\n\n==== REALIZANDO LOGIN (VENDEDOR) ====");
        System.out.println("Nome: "   + super.getName());
        System.out.println("E-mail: " + super.getEmail());
        System.out.println("Senha: "  + super.getPassword());
        System.out.println("Admin: "  + super.getAdmin());
    }

    @Override
    public void logff() {
        System.out.println("\n\n==== SAINDO DA CONTA (VENDEDOR) ====");
        System.out.println("Nome: "   + super.getName());
        System.out.println("E-mail: " + super.getEmail());
        System.out.println("Senha: "  + super.getPassword());
        System.out.println("Admin: "  + super.getAdmin());
    }

    @Override
    public void editProfile() {
        System.out.println("\n\n==== EDITANDO PERFIL (VENDEDOR) ====");
        
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
        System.out.println("\n\n==== EDITANDO SENHA (VENDEDOR) ====");
        String password;

        System.out.print("Editando senha: ");
        password = sc.next();

        super.setPassword(password);
    }
}
