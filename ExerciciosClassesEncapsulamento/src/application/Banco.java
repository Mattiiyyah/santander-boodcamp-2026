package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.ContaBancaria;

public class Banco {

    private static final int CONSULTAR_SALDO            = 1;
    private static final int CONSULTAR_CHEQUE           = 2;
    private static final int DEPOSITAR                  = 3;
    private static final int SACAR                      = 4;
    private static final int PAGAR_BOLETO               = 5;
    private static final int VERIFICAR_CHEQUE_ESPECIAL  = 6;
    private static final int SAIR                       = 0;

    public void executar(Scanner sc) {
       
        

        // --- Criação da conta com depósito inicial ---
        double depositoInicial = 0.0;

        do {
            try {
                System.out.print("\nDigite o valor do depósito inicial da conta: R$ ");
                depositoInicial = sc.nextDouble();
                sc.nextLine();

                if (depositoInicial <= 0) {
                    throw new Exception("O depósito inicial deve ser maior que zero.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Digite apenas números para o valor.");
                System.out.println("####################################################");
                System.out.println("\nTente novamente!!!");
                depositoInicial = 0.0;
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("\n####################################################");
                System.out.println("Erro: " + e.getMessage());
                System.out.println("####################################################");
                System.out.println("\nTente novamente!!!");
                depositoInicial = 0.0;
            }
        } while (depositoInicial <= 0);

        ContaBancaria conta = new ContaBancaria(depositoInicial);
        System.out.println("\nConta criada com sucesso!");
        System.out.printf("Saldo inicial: R$%.2f%n", conta.getValorConta());
        System.out.printf("Limite do cheque especial: R$%.2f%n", conta.limiteCheque());

        // --- Menu principal ---
        int opcao = -1;

        while (opcao != SAIR) {
            System.out.println("\n\n============== MENU DO BANCO ==============");
            System.out.println(CONSULTAR_SALDO           + " - Consultar saldo");
            System.out.println(CONSULTAR_CHEQUE          + " - Consultar cheque especial");
            System.out.println(DEPOSITAR                 + " - Depositar");
            System.out.println(SACAR                     + " - Sacar");
            System.out.println(PAGAR_BOLETO              + " - Pagar boleto");
            System.out.println(VERIFICAR_CHEQUE_ESPECIAL + " - Verificar se está usando cheque especial");
            System.out.println(SAIR                      + " - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case CONSULTAR_SALDO:
                        System.out.printf("\nSaldo atual: R$%.2f%n", conta.getValorConta());
                        break;

                    case CONSULTAR_CHEQUE:
                        System.out.printf("\nLimite do cheque especial: R$%.2f%n", conta.limiteCheque());
                        break;

                    case DEPOSITAR:
                        double valorDeposito = lerValor(sc, "Digite o valor do depósito: R$ ");
                        conta.depositar(valorDeposito);
                        System.out.printf("\nDepósito realizado. Saldo atual: R$%.2f%n", conta.getValorConta());
                        break;

                    case SACAR:
                        double saldoDisponivel = conta.getValorConta() + conta.limiteCheque();
                        System.out.printf("\nSaldo disponível (incluindo cheque especial): R$%.2f%n", saldoDisponivel);
                        double valorSaque = lerValorComLimite(sc, "Digite o valor do saque: R$ ", saldoDisponivel);
                        conta.sacar(valorSaque);
                        System.out.printf("\nSaque realizado. Saldo atual: R$%.2f%n", conta.getValorConta());
                        if (conta.verificarSeUsandoChequeEspecial()) {
                            System.out.printf("\nAtenção: conta usando cheque especial! Saldo: R$%.2f%n", conta.getValorConta());
                        }
                        break;

                    case PAGAR_BOLETO:
                        double saldoDisponivlBoleto = conta.getValorConta() + conta.limiteCheque();
                        System.out.printf("\nSaldo disponível (incluindo cheque especial): R$%.2f%n", saldoDisponivlBoleto);
                        double valorBoleto = lerValorComLimite(sc, "Digite o valor do boleto: R$ ", saldoDisponivlBoleto);
                        conta.pagarBoleto(valorBoleto);
                        System.out.printf("\nBoleto pago. Saldo atual: R$%.2f%n", conta.getValorConta());
                        if (conta.verificarSeUsandoChequeEspecial()) {
                            System.out.printf("\nAtenção: conta usando cheque especial! Saldo: R$%.2f%n", conta.getValorConta());
                        }
                        break;

                    case VERIFICAR_CHEQUE_ESPECIAL:
                        if (conta.verificarSeUsandoChequeEspecial()) {
                            System.out.printf("\nConta está usando o cheque especial. Saldo negativo: R$%.2f%n", conta.getValorConta());
                        } else {
                            System.out.println("\nConta não está usando o cheque especial.");
                        }
                        break;

                    case SAIR:
                        System.out.println("\nSaindo... Até logo!");
                        break;

                    default:
                        System.out.println("\n[!] Opção inválida. Escolha um número do menu.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Digite apenas números inteiros para a opção do menu.");
                System.out.println("####################################################");
                sc.nextLine();
            }
        }
    }

    // Lê um valor positivo do usuário com validação
    private double lerValor(Scanner sc, String mensagem) {
        double valor = 0.0;

        do {
            try {
                System.out.print(mensagem);
                valor = sc.nextDouble();
                sc.nextLine();

                if (valor <= 0) {
                    throw new Exception("O valor deve ser maior que zero.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Digite apenas números para o valor.");
                System.out.println("####################################################");
                System.out.println("\nTente novamente!!!");
                valor = 0.0;
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("\n####################################################");
                System.out.println("Erro: " + e.getMessage());
                System.out.println("####################################################");
                System.out.println("\nTente novamente!!!");
                valor = 0.0;
            }
        } while (valor <= 0);

        return valor;
    }

    // Lê um valor positivo do usuário com validação e limite máximo
    private double lerValorComLimite(Scanner sc, String mensagem, double limite) {
        double valor = 0.0;

        do {
            try {
                System.out.print(mensagem);
                valor = sc.nextDouble();
                sc.nextLine();

                if (valor <= 0) {
                    throw new Exception("O valor deve ser maior que zero.");
                }

                if (valor > limite) {
                    throw new Exception(String.format("Saldo insuficiente. Máximo disponível: R$%.2f", limite));
                }

            } catch (InputMismatchException e) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Digite apenas números para o valor.");
                System.out.println("####################################################");
                System.out.println("\nTente novamente!!!");
                valor = 0.0;
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("\n####################################################");
                System.out.println("Erro: " + e.getMessage());
                System.out.println("####################################################");
                System.out.println("\nTente novamente!!!");
                valor = 0.0;
            }
        } while (valor <= 0);

        return valor;
    }
}
