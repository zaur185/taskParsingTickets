package model;

import java.util.List;

public class Root {
    private List<Tickets> tickets;

    public List<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "model.Root{" +
                "tickets=" + tickets +
                '}';
    }
}
