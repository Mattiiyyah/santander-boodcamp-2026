package entities.ex2;

import java.util.Scanner;

public final class Manager extends Employee {

    private final Scanner sc = new Scanner(System.in);

    public Manager(String name, String email, String password) {
        super(name, email, password, true);
    }
    
    public void generateFinancialReport() {
        System.out.println("\n=== RELATÓRIO FINANCEIRO =========");
        System.out.println("Receita Total Mensal: R$ 150.000,00");
        System.out.println("Despesas Totais: R$ 90.000,00");
        System.out.println("Lucro Líquido: R$ 60.000,00");
        System.out.println("====================================");
    }

    public void consultSales() {
        System.out.println("\n=== CONSULTA DE VENDAS ============");
        System.out.println("Total de Vendas no Mês: 345 unidades");
        System.out.println("Produto Mais Vendido: Notebook Lenovo");
        System.out.println("Valor Médio por Venda: R$ 2.500,00");
        System.out.println("====================================");
    }

    @Override
    public void login() {
        System.out.println("\n\n==== REALIZANDO LOGIN ====");
        System.out.println("Nome: "   + super.getName());
        System.out.println("E-mail: " + super.getEmail());
        System.out.println("Senha: "  + super.getPassword());
        System.out.println("Admin: "  + super.getAdmin());
    }

    @Override
    public void logff() {
        System.out.println("\n\n==== SAINDO DA CONTA ====");
        System.out.println("Nome: "   + super.getName());
        System.out.println("E-mail: " + super.getEmail());
        System.out.println("Senha: "  + super.getPassword());
        System.out.println("Admin: "  + super.getAdmin());
    }

    @Override
    public void editProfile() {
       
       System.out.println("\n\n==== EDITANDO PERFIL ====");
       
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
        System.out.println("\n\n==== EDITANDO SENHA (GERENTE) ====");
        String password;

        System.out.print("Editando senha: ");
        password = sc.next();

        super.setPassword(password);

    }
}
