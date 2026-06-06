package entities.ex1;

public abstract class Ticket {

    private Double value;
    private String nameMovie;
    private boolean status;

    public Ticket(Double value, String nameMovie, boolean status) {
        this.value = value;
        this.nameMovie = nameMovie;
        this.status = status;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getStatus() {
        return status ? "dublado" : "legendado";
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public abstract double ticketValue();

}
