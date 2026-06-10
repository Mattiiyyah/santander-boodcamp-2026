package ex1;

public final class Sms implements Message {

    private String phone;

    public Sms(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public void sendMessage(String message) {
        System.out.println("\n================================================");
        System.out.println("                  ENVIANDO SMS                  ");
        System.out.println("================================================");
        System.out.println("Destinatário (Número): " + phone);
        System.out.println("Mensagem: " + message);
        System.out.println("================================================\n");
    }

}
