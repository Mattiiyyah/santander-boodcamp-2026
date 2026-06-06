package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.ex1.FamilyTicket;
import entities.ex1.HalfTicket;
import entities.ex1.Ticket;
import entities.ex2.Attendant;
import entities.ex2.Employee;
import entities.ex2.Manager;
import entities.ex2.Salesperson;
import entities.ex3.BRLClock;
import entities.ex3.Clock;
import entities.ex3.USClock;

public class Program {

    private static final int EXERCICIO_CINEMA = 1;
    private static final int EXERCICIO_EMPLOYEE = 2;
    private static final int EXERCICIO_RELOGIO = 3;
    private static final int SAIR = 0;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int opcao = -1;

        while (opcao != SAIR) {
            System.out.println("\n\n============== MENU DE EXERCÍCIOS ==============");
            System.out.println(EXERCICIO_CINEMA + " Consultar exercício Cinema");
            System.out.println(EXERCICIO_EMPLOYEE + " Consultar exercício Empregados");
            System.out.println(EXERCICIO_RELOGIO + " Consultar exercício Relogio");
            System.out.println(SAIR + " - Sair");
            System.out.print("\nEscolha uma opção: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case EXERCICIO_CINEMA:
                        getTicket(sc);
                        break;
                    case EXERCICIO_EMPLOYEE:
                        getEmployee(sc); 
                        break;
                    case EXERCICIO_RELOGIO:
                        getClock(sc);
                        break;
                    default:
                        System.out.println("\n[!] Opção inválida. Escolha um número do menu.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[!] Erro: Digite apenas números inteiros para a opção do menu.");
                sc.nextLine();
            }
        }

        sc.close();
    }

    private static void getTicket(Scanner sc) {

        final int HALF_TICKET   = 1;
        final int FAMILY_TICKET = 2;

        Ticket ticket = null;

        System.out.println("\n========== EXERCÍCIO 1: Cinema ==========");
        System.out.println("Escolha uma opcao abaixo: ");
        System.out.println(HALF_TICKET + " - Ingresso de meia entrada");
        System.out.println(FAMILY_TICKET + " - Ingresso Familia");
        System.out.print("\nDigite sua opcao aqui: ");
        int opcao = sc.nextInt();

        switch (opcao) {
            case HALF_TICKET:
                ticket = new HalfTicket(40.0, "Filme X", true);
                break;
        
            case FAMILY_TICKET:
                FamilyTicket familyTicket = new FamilyTicket(40.0, "Filme X", true);
                familyTicket.validationPerson(sc);
                ticket = familyTicket;
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        // POLIMORFISMO NA PRÁTICA:
        if (ticket != null) {
            System.out.printf("\nO valor final do ingresso é R$ %.2f\n", ticket.ticketValue());
        }
    }

    private static void getEmployee(Scanner sc) {
        final int MANAGER     = 1;
        final int SALESPERSON = 2;
        final int ATTENDANT   = 3; 

        Employee employee = null;

        System.out.println("\n========== EXERCÍCIO 2: EMPREGADO ==========");
        System.out.println("Escolha uma opcao abaixo: ");
        System.out.println(MANAGER + " - consultar class GERENTE");
        System.out.println(SALESPERSON + " - consultar class VENDEDOR");
        System.out.println(ATTENDANT + "- consultar class ATENDENTE");
        int opcao = sc.nextInt();

        switch (opcao) {
            case MANAGER:
                Manager manager = new Manager("Caio Castro", "caio@gmail.com", "123Caio");
                menuManager(manager, sc);
                employee = manager;
                break;
            
            case SALESPERSON:
                Salesperson salesperson = new Salesperson("Joao Silva", "joao@gmail.com", "321Jao");
                menuSalesperson(salesperson, sc);
                employee = salesperson;
                break;
                
            case ATTENDANT: 
                Attendant attendant = new Attendant("Lorenzo Rodrigues", "lorenzo@gmail.com", "213Lorenzo");
                menuAttendant(attendant, sc);
                employee = attendant;
                break;
                
            default:
                System.out.println("Opção inválida!");
                break;
        }

        if (employee != null) {
            System.out.println("\n[SISTEMA] Sessão finalizada para o usuário: " + employee.getName());
            System.out.println("Status da conta: " + employee.getAdmin());
        }
    }

    private static void menuManager(Manager manager, Scanner sc) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- MENU GERENTE ---");
            System.out.println("1 - Realizar login");
            System.out.println("2 - Gerar relatório financeiro");
            System.out.println("3 - Consultar vendas");
            System.out.println("4 - Alterar dados");
            System.out.println("5 - Alterar senha");
            System.out.println("6 - Realizar logoff");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1: manager.login(); 
                   break;
                case 2: manager.generateFinancialReport(); 
                   break;
                case 3: manager.consultSales(); 
                   break;
                case 4: manager.editProfile(); 
                   break;
                case 5: manager.changePassword(); 
                   break;
                case 6: manager.logff(); 
                   break;
                case 0: System.out.println("Voltando..."); 
                   break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuSalesperson(Salesperson salesperson, Scanner sc) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- MENU VENDEDOR ---");
            System.out.println("1 - Realizar login");
            System.out.println("2 - Realizar venda");
            System.out.println("3 - Consultar vendas");
            System.out.println("4 - Alterar dados");
            System.out.println("5 - Alterar senha");
            System.out.println("6 - Realizar logoff");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1: salesperson.login(); break;
                case 2: salesperson.registerSale(); break;
                case 3: salesperson.consultSales(); break;
                case 4: salesperson.editProfile(); break;
                case 5: salesperson.changePassword(); break;
                case 6: salesperson.logff(); break;
                case 0: System.out.println("Voltando..."); break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuAttendant(Attendant attendant, Scanner sc) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- MENU ATENDENTE ---");
            System.out.println("1 - Realizar login");
            System.out.println("2 - Receber pagamento");
            System.out.println("3 - Fechar o caixa");
            System.out.println("4 - Alterar dados");
            System.out.println("5 - Alterar senha");
            System.out.println("6 - Realizar logoff");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1: attendant.login(); break;
                case 2: 
                    System.out.print("Digite o valor do pagamento (Ex: 50.50): ");
                    double valor = sc.nextDouble();
                    sc.nextLine(); // limpar buffer
                    attendant.receivePayment(valor); 
                    break;
                case 3: attendant.closeRegister(); 
                    break;
                case 4: attendant.editProfile(); 
                    break;
                case 5: attendant.changePassword(); 
                    break;
                case 6: attendant.logff(); 
                    break;
                case 0: System.out.println("Voltando..."); 
                    break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private static void getClock(Scanner sc) {
        final int BRL_CLOCK = 1;
        final int US_CLOCK  = 2;

        Clock clock = null;

        System.out.println("\n========== EXERCÍCIO 3: RELÓGIO ==========");
        System.out.println("Escolha uma opcao abaixo: ");
        System.out.println(BRL_CLOCK + " - Relógio Brasileiro");
        System.out.println(US_CLOCK + " - Relógio Americano");
        System.out.print("\nDigite sua opcao aqui: ");
        int opcao = sc.nextInt();

        switch (opcao) {
            case BRL_CLOCK:
                clock = new BRLClock();
                break;
            case US_CLOCK:
                clock = new USClock();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        if (clock != null) {
            System.out.print("Digite a hora: ");
            clock.setHour(sc.nextInt());
            System.out.print("Digite os minutos: ");
            clock.setMinute(sc.nextInt());
            System.out.print("Digite os segundos: ");
            clock.setSecond(sc.nextInt());

            System.out.println("\n[SISTEMA] Relógio configurado com sucesso!");
            if (clock instanceof USClock) {
                System.out.printf("Hora formatada: %s %s\n", clock.getTime(), ((USClock) clock).getPeriodIndicator());
            } else {
                System.out.printf("Hora formatada: %s\n", clock.getTime());
            }

            System.out.println("\nDeseja converter para o outro formato? (1 - Sim / 0 - Não)");
            int converter = sc.nextInt();
            
            if (converter == 1) {
                Clock convertedClock;
                if (clock instanceof BRLClock) {
                    convertedClock = new USClock();
                } else {
                    convertedClock = new BRLClock();
                }
                convertedClock.convert(clock);
                
                System.out.println("\n[SISTEMA] Relógio convertido com sucesso!");
                if (convertedClock instanceof USClock) {
                    System.out.printf("Nova hora formatada: %s %s\n", convertedClock.getTime(), ((USClock) convertedClock).getPeriodIndicator());
                } else {
                    System.out.printf("Nova hora formatada: %s\n", convertedClock.getTime());
                }
             }
        }
    }
}
