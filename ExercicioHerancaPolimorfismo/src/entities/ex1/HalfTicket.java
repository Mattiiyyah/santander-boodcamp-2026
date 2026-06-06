package entities.ex1;

public final class HalfTicket extends Ticket {

    public HalfTicket(Double value, String nameMovie, boolean status) {
        super(value, nameMovie, status);
    }

    @Override
    public double ticketValue() {
       double halfvalue = (getValue() / 2);
       return halfvalue;
    }    
}
