package net.serenitybdd.demos.todos.screenplay.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.demos.todos.screenplay.user_interface.ContactUsItem;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SendFormAndAcceptAlerts implements Task {

    public static Performable sendFormAcceptAlert(){
        return instrumented(SendFormAndAcceptAlerts.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ContactUsItem.SUBMIT_BTN));
    }
}
