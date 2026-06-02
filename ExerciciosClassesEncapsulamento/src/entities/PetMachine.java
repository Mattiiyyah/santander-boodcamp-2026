package entities;

public class PetMachine {
    
    private boolean limpo = true;
    private int agua = 30;
    private int shampoo = 10;
    private Pet pet;

    public void darBanhoPet() {
        if(this.pet == null) {
            System.out.println("\nColoque o pet na máquina para iniciar o banho.");
            return;
        }

        this.agua -= 10;
        this.shampoo -= 2;

        pet.setLimpo(true);
        System.out.println("\nO pet " + pet.getNome() + " está limpo!");
    }

    public void addAgua() {
        if(agua == 30) {
            System.out.println("A capacidadde de água da máquina está no máximo");
            return;
        }

        agua += 2;
    }

     public void addShampoo() {
        if(shampoo == 10) {
            System.out.println("A capacidadde de shampoo da máquina está no máximo");
            return;
        }

        shampoo += 2;
    }

     public int getAgua() {
         return agua;
     }

     public int getShampoo() {
         return shampoo;
     }

    public boolean temPet() {
        return pet != null;
    }

    public void setPet(Pet pet) {
        if(!this.limpo) {
            System.out.println("A máquina está suja, para colocar o pet é necessário limpa-lá");
            return;
        }

        if(temPet()) {
            System.out.println("O pet " + this.pet.getNome() + " está na máquina nesse momento ");
            return;
        }

        this.pet = pet;
        System.out.println("\nO pet " + pet.getNome() + " foi colocado na máquina");
    }

    public void removerPet() {
        this.limpo = this.pet.isLimpo();

        System.out.println("\nO pet " + this.pet.getNome() + " foi tirado da máquina");
        this.pet = null;
    }

    public void limparMaquina() {
        this.agua -= 10;
        this.shampoo -= 2;
        this.limpo = true;
        System.out.println("\nA máquina foi limpa");
    }


}
