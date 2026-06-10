package ex2;

public final class Food implements Product {
    private double amount;
    

    public Food(double amount) {
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
       final double TAX = 0.01;

       amount += amount * TAX;
       
       System.out.printf("\nValor do Imposto do Alimento: R$%.2f", amount);
    }

    
}
