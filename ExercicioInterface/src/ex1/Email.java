package ex1;

public final class Email implements Message {

    private String emailAddress;

    public Email(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("\n================================================");
        System.out.println("                ENVIANDO E-MAIL                 ");
        System.out.println("================================================");
        System.out.println("Destinatário (E-mail): " + emailAddress);
        System.out.println("Mensagem: " + message);
        System.out.println("================================================\n");
    }

}
