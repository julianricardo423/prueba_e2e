package net.serenitybdd.demos.todos.screenplay.tasks;

import net.serenitybdd.demos.todos.screenplay.user_interface.ContactUsItem;
import net.serenitybdd.demos.todos.screenplay.user_interface.HomeItem;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BackToHome implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ContactUsItem.HOME_BTN));
    }

    public static Performable toHome() {
        return instrumented(BackToHome.class);
    }
}
