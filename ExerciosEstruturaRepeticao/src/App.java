import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class App {

    // Constantes para o menu
    private static final int EXERCICIO_TABUADA      = 1;
    private static final int EXERCICIO_IMC          = 2;
    private static final int EXERCICIO_PARES_IMPARES = 3;
    private static final int EXERCICIO_NUMERO_DIFERENTE = 4;
    private static final int SAIR = 0;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int opcao = -1;

        while (opcao != SAIR) {
            System.out.println("\n\n============== MENU DE EXERCÍCIOS ==============");
            System.out.println(EXERCICIO_TABUADA       + " - Tabuada (Ex 1)");
            System.out.println(EXERCICIO_IMC           + " - IMC (Ex 2)");
            System.out.println(EXERCICIO_PARES_IMPARES + " - Pares e Ímpares (Ex 3)");
            System.out.println(EXERCICIO_NUMERO_DIFERENTE + " - Número Diferente (Ex 4)");
            System.out.println(SAIR                    + " - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case EXERCICIO_TABUADA:
                        Tabuada.tabuada(sc);
                        break;
                    case EXERCICIO_IMC:
                        IndiceMassa.imc(sc);
                        break;
                    case EXERCICIO_PARES_IMPARES:
                        ParesImpares.numeros(sc);
                        break;
                    case EXERCICIO_NUMERO_DIFERENTE:
                        NumeroDiferente.numeros(sc);
                        break;
                    case SAIR:
                        System.out.println("\nSaindo do programa... Até logo!");
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
}
