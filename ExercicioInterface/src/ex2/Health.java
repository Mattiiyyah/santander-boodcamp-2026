package ex2;

public final class Health implements Product {
    private double amount;
    

    public Health(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public void taxAmount() {
       final double TAX = 0.015;

       amount += amount * TAX;
       
       System.out.printf("\nValor do Imposto de Saude e bem estar: R$%.2f", amount);
    }
}
