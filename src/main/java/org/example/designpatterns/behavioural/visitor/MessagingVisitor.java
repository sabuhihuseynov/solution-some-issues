package org.example.designpatterns.behavioural.visitor;

import java.util.List;

public class MessagingVisitor implements Visitor {

    public void sendInsuranceMails(List<Client> clients) {
        clients.forEach(client -> client.accept(this));
    }

    @Override
    public void visitBank(Bank bank) {
        System.out.println("Sending email to the bank");
    }

    @Override
    public void visitResident(Resident resident) {
        System.out.println("Sending email to the resident");
    }

    @Override
    public void visitRestaurant(Restaurant restaurant) {
        System.out.println("Sending email to the restaurant");
    }
}
