package at.jul.projects.oop.ticketmachine.objects;

import at.jul.projects.oop.ticketmachine.objects.ticketmanagero.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Ticketmanager {
    private List<Ticket> tickets;
    private Calculator calculator;

    public Ticketmanager(Calculator calculator) {
        this.calculator = calculator;
        this.tickets = new ArrayList<>();
    }

    public void createTicket(){
        Ticket ticket = new Ticket(tickets.size()+1);

        tickets.add(ticket);
        System.out.println(tickets.size());
    }

    private void removeTicket(int tickerIDNumber){
        tickets.remove(searchForTicket(tickerIDNumber));
    }

    public void payAndRemoveTicket(int tickerIDNumber){
        Ticket ticketTimeDifference = searchForTicket(tickerIDNumber);

        calculator.payTicket(calculator.chargeMoney(ticketTimeDifference));

        removeTicket(tickerIDNumber);
    }



    private Ticket searchForTicket(int tickerIDNumber) {
        Ticket ticketReturn = null;
        for (int i = 0; i < tickets.size(); i++) {
            if(tickerIDNumber == tickets.get(i).getId()){
                ticketReturn = tickets.get(i);
            }
        }
        return ticketReturn;
    }
}
