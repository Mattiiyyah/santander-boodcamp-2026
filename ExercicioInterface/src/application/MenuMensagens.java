package application;

import java.util.InputMismatchException;
import java.util.Scanner;
import ex1.Sms;
import ex1.Email;
import ex1.RedeSocial;
import ex1.WhatsApp;

public abstract class MenuMensagens {

    private static final  int SMS        = 1;
    private static final  int EMAIL      = 2;
    private static final  int REDESOCIAL = 3;
    private static final  int WHATSAPP   = 4;
    private static final  int EXIT       = 0;

    public static void exibirMenu(Scanner sc) {

        String defaultMessage = obterMensagemPadrao();

        int opcao = -1;
       
        while (opcao != EXIT) {

            System.out.println("\n========== EXERCICIO 1 ==============");
            System.out.println("\nEscolha uma opção abaixo:   ");
            System.out.println(SMS        + " - consultar mensagem SMS");
            System.out.println(EMAIL      + " - consultar mensagem EMAIL");
            System.out.println(REDESOCIAL + " - consultar mensagem REDESOCIAL");
            System.out.println(WHATSAPP   + " - consultar mensagem WHATSAPP");
            System.out.println(EXIT       + " - SAIR");

           try {

                opcao = sc.nextInt();
                sc.nextLine(); 

                switch (opcao) {
                    case SMS:
                        String phoneSms = validarTelefone(sc);
                        Sms sms = new Sms(phoneSms);
                        sms.sendMessage(defaultMessage);
                        break;
                    
                    case EMAIL: 
                        String email = validarEmail(sc);
                        Email objEmail = new Email(email);
                        objEmail.sendMessage(defaultMessage);
                        break;
                        
                    case REDESOCIAL:
                        String username = validarUsuario(sc);
                        RedeSocial rede = new RedeSocial(username);
                        rede.sendMessage(defaultMessage);
                        break;
                        
                    case WHATSAPP:
                        String phoneWpp = validarTelefone(sc);
                        WhatsApp wpp = new WhatsApp(phoneWpp);
                        wpp.sendMessage(defaultMessage);
                        break;
                    case EXIT: 
                        System.out.println("\nSaindo do exercício 1");
                        break; 
                    default:
                        System.out.println("\n[!] Opção inválida no menu de mensagens.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[!] Erro: Digite apenas números inteiros para a opção do menu.");
                sc.nextLine();
            }

        }
    }

    private static String validarTelefone(Scanner sc) {
        String phone;
        boolean isValid;
        do {
            System.out.print("Digite o número do telefone (ex: 11987654321): ");
            phone = sc.nextLine();
            isValid = phone != null && phone.matches("\\d{2}-?\\d{8,9}");
            
            if (!isValid) {
                System.out.println("[!] Telefone inválido. O formato deve conter o DDD e o número (com ou sem traço). Tente novamente.");
            }
        } while (!isValid);
    
        return phone;
    }

    private static String validarEmail(Scanner sc) {
        String email;
        boolean isValid;
        do {
            System.out.print("Digite o endereço de e-mail (ex: contato@email.com): ");
            email = sc.nextLine();
            // Regex básico para validar e-mail
            isValid = email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
            
            if (!isValid) {
                System.out.println("[!] E-mail inválido. O formato deve ser como nome@dominio.com. Tente novamente.");
            }
        } while (!isValid);
    
        return email;
    }

    private static String validarUsuario(Scanner sc) {
        String username;
        boolean isValid;
        do {
            System.out.print("Digite o nome de usuário (ex: @joaosilva): ");
            username = sc.nextLine();
            // Regex validando que o nome comece com @ e tenha pelo menos um caractere
            isValid = username != null && username.matches("^@[\\w\\.]+$");
            
            if (!isValid) {
                System.out.println("[!] Nome de usuário inválido. O formato deve começar com '@' sem espaços. Tente novamente.");
            }
        } while (!isValid);
    
        return username;
    }

    private static String obterMensagemPadrao() {
        return "Somente nesta semana, novos clientes podem contratar nosso plano de internet de 500 MB.";
    }
}
