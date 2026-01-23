package net.serenitybdd.demos.todos.screenplay.tasks;

import net.serenitybdd.demos.todos.screenplay.user_interface.ContactUsItem;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillFormContactUs implements Task {

    private String name;
    private String email;
    private String subject;
    private String message;

    public FillFormContactUs(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public static Performable sendMessageInForm(String name, String email, String subject, String message){
        return instrumented(FillFormContactUs.class, name, email, subject, message);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(name).into(ContactUsItem.NAME_FIELD),
                Enter.theValue(email).into(ContactUsItem.EMAIL_FIELD),
                Enter.theValue(subject).into(ContactUsItem.SUBJECT_FIELD),
                Enter.theValue(message).into(ContactUsItem.MESSAGE_FIELD)
        );
    }
}
