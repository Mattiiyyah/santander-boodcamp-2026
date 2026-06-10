package ex1;

public final class RedeSocial implements Message {

    private String username;

    public RedeSocial(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("\n================================================");
        System.out.println("             MENSAGEM REDE SOCIAL               ");
        System.out.println("================================================");
        System.out.println("Destinatário (Usuário): " + username);
        System.out.println("Mensagem: " + message);
        System.out.println("================================================\n");
    }

}
