package org.example.designpatterns.behavioural.visitor;

public interface Visitor {

    void visitBank(Bank bank);
    void visitResident(Resident resident);
    void visitRestaurant(Restaurant restaurant);

}
