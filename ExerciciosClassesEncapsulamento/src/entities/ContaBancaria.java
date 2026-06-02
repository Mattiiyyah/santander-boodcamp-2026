package entities;

public final class ContaBancaria {
    
    private final double VALOR = 500.00;
    private final double PERCENTUAL = 0.50;

    private double valorConta;
    private double depositoInicial;
    private double boleto;
    
    public ContaBancaria(double valorConta) {
        this.valorConta = valorConta;
        this.depositoInicial = valorConta;
        this.boleto = 0;
    }

    public double getValorConta() {
        return valorConta;
    }

    public double getBoleto() {
        return boleto;
    }
    
    public double limiteCheque() {
        double chequeEspecial = 0.0;

        if(depositoInicial <= VALOR) {
            chequeEspecial = 50.00;
        } else {
            chequeEspecial = depositoInicial * PERCENTUAL;
        }

        return chequeEspecial;
    }

    public double depositar(double valor) {
        boolean estavaNoCheque = verificarSeUsandoChequeEspecial();
        double valorUsado = estavaNoCheque ? Math.abs(valorConta) : 0;

        this.valorConta += valor;

        if (estavaNoCheque && !verificarSeUsandoChequeEspecial()) {
            cobrarTaxaEspecial(valorUsado);
        }

        return getValorConta();
    }

    public double sacar(double valor) {
        this.valorConta -= valor;
        return getValorConta();
    }

    public double pagarBoleto(double boleto) {
       this.boleto = boleto;
       this.valorConta -= this.boleto;
       return getValorConta();
    }

    public boolean verificarSeUsandoChequeEspecial() {
        return valorConta < 0;
    }

    private void cobrarTaxaEspecial(double valorUsado) {
        double taxa = valorUsado * 0.20;
        this.valorConta -= taxa;
    }

}
