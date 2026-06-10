package ex1;

public final class WhatsApp implements Message {

    private String phone;

    public WhatsApp(String phone) {
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
        System.out.println("               MENSAGEM WHATSAPP                ");
        System.out.println("================================================");
        System.out.println("Destinatário (WhatsApp): " + phone);
        System.out.println("Mensagem: " + message);
        System.out.println("================================================\n");
    }

}
