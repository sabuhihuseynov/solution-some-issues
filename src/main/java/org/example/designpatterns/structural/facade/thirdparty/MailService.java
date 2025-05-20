package org.example.designpatterns.structural.facade.thirdparty;

public class MailService {

    public void sendConfirmationMail(User user) {
        System.out.println("Sending mail to " + user.name());
    }

}
