package ex2;

public final class Culture implements Product {
    private double amount;
    

    public Culture(double amount) {
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
       final double TAX = 0.04;

       amount += amount * TAX;
       
       System.out.printf("\nValor do Imposto de Cultura: R$%.2f", amount);
    }
}
