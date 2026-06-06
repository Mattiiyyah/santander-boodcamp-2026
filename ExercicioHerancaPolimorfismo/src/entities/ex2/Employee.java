package entities.ex2;

public abstract class Employee {
    private String name;
    private String email;
    private String password;
    private boolean admin;
    
    public Employee(String name, String email, String password, boolean admin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdmin() {
        return admin ? "É admin" : "Não é admin";
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public abstract void login();

    public abstract void logff();

    public abstract void editProfile();

    public abstract void changePassword();
    
}
