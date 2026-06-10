package ex2;

public final class Clothing implements Product {
   private double amount;
    

    public Clothing(double amount) {
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
       final double TAX = 0.025;

       amount += amount * TAX;
       
       System.out.printf("\nValor do Imposto do Vestuário: R$%.2f", amount);
    }
} 
