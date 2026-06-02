package entities;

public class FuncionalidadesCarro {
    private int velocidade;
    private int marcha;
    private String statusAtividade;

    public FuncionalidadesCarro() {
        this.velocidade = 0;
        this.marcha = 0;
        this.statusAtividade = "desligado";
    }

    public int getVelocidade() {
        return velocidade;
    }

    public String getStatusAtividade() {
        return statusAtividade;
    }

    public int getMarcha() {
        return marcha;
    }

    private int velocidadeMaximaDaMarcha(int marcha) {
        switch (marcha) {
            case 1:
                return 20;
            case 2:
                return 40;
            case 3:
                return 60;
            case 4:
                return 80;
            case 5:
                return 100;
            case 6:
                return 120;
            default:
                return 0;
        }
    }

    private int velocidadeMinimaDaMarcha(int marcha) {
        switch (marcha) {
            case 2:
                return 21;
            case 3:
                return 41;
            case 4:
                return 61;
            case 5:
                return 81;
            case 6:
                return 101;
            default:
                return 0;
        }
    }

    public void trocarMarcha(int marcha) {
        if (!(getStatusAtividade().equalsIgnoreCase("ligado"))) {
            System.out.println("\nO CARRO ESTÁ DESLIGADO");
            return;
        }

        if (!(marcha >= 0 && marcha <= 6)) {
            System.out.println("\nINFORME A MARCHA CORRETAMENTE (0 A 6)");
            return;
        }

        boolean bloquearTroca = Math.abs(marcha - this.marcha) != 1;

        if (bloquearTroca) {
            System.out.println("\nNÃO É POSSIVEL PULAR DE UMA MARCHA PARA OUTRA");
            return;
        }

        boolean subindoMarcha = marcha > this.marcha;

        if (subindoMarcha) {
            // Subindo: só verifica se não passa do máximo da nova marcha
            if (this.velocidade > velocidadeMaximaDaMarcha(marcha)) {
                System.out.println("\nVelocidade alta demais para a marcha " + marcha + " (máx: " + velocidadeMaximaDaMarcha(marcha) + "km/h)");
                return;
            }
        } else {
            // Descendo: verifica o range completo da nova marcha
            if (this.velocidade > velocidadeMaximaDaMarcha(marcha) || this.velocidade < velocidadeMinimaDaMarcha(marcha)) {
                System.out.println("\nVelocidade incompatível com a marcha " + marcha +
                        " (entre " + velocidadeMinimaDaMarcha(marcha) + "km/h e " + velocidadeMaximaDaMarcha(marcha) + "km/h)");
                return;
            }
        }

        this.marcha = marcha;

        System.out.println("\nTroca de Marcha: " + getMarcha());

    }

    public void ligarCarro() {
        this.statusAtividade = "ligado";
        System.out.println("\nCarro ligado!");
    }

    public void desligarCarro() {
        if (!(marcha == 0 && velocidade == 0)) {
            System.out.println("\nO carro não pode ser desligado pois não está no ponto morto");
            return;
        }

        this.statusAtividade = "desligado";
        System.out.println("\nCarro desligado!");
    }

    public void acelerar() {
        if (!(getStatusAtividade().equalsIgnoreCase("ligado"))) {
            System.out.println("\nO CARRO ESTÁ DESLIGADO");
            return;
        }

        if (getMarcha() == 0) {
            System.out.println("\nMarcha 0 (ponto morto) não pode acelerar");
            return;
        }

        if (this.velocidade >= velocidadeMaximaDaMarcha(this.marcha)) {
            System.out.println("\nVelocidade máxima da marcha " + marcha + " atingida!");
            return;
        }

        this.velocidade += 1;
        System.out.println("\nVelocidade atual: " + getVelocidade() + "km/h");
    }

    public void diminuir() {
        if (!(getStatusAtividade().equalsIgnoreCase("ligado"))) {
            System.out.println("\nO CARRO ESTÁ DESLIGADO");
            return;
        }

        if (this.velocidade <= 0) {
            System.out.println("\nO carro já está na velocidade mínima (0km)");
            return;
        }

        if (this.velocidade <= velocidadeMinimaDaMarcha(this.marcha)) {
            System.out.println("\nVelocidade mínima da marcha " + marcha + " atingida!\n");
            return;
        }

        this.velocidade -= 1;
        System.out.println("\nVelocidade atual: " + getVelocidade() + "km/h");
    }

    public void verificarVelocidade() {
        System.out.println("\nVelocidade atual: " + getVelocidade() + "km/h | Marcha: " + getMarcha());
    }

    public void virarCarro(String direcao) {
        if (!getStatusAtividade().equalsIgnoreCase("ligado")) {
            System.out.println("\nO CARRO ESTÁ DESLIGADO");
            return;
        }

        if (!direcao.equalsIgnoreCase("esquerda") && !direcao.equalsIgnoreCase("direita")) {
            System.out.println("\nDireção inválida! Informe 'esquerda' ou 'direita'");
            return;
        }

        if (this.velocidade < 1 || this.velocidade > 40) {
            System.out.println("\nO carro só pode virar entre 1km/h e 40km/h. Velocidade atual: " + getVelocidade() + "km/h");
            return;
        }

        System.out.println("\nCarro virando para a " + direcao + " a " + getVelocidade() + "km/h");
     }
}
