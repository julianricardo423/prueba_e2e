package net.serenitybdd.demos.todos.screenplay.tasks;


import net.serenitybdd.demos.todos.screenplay.user_interface.HomeItem;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;



import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Start implements Task {

    public static Performable openBrowser() {
        return Task.where("{0} Abrir página de prueba",
                Open.browserOn().thePageNamed("home.page")
        );
    }

    public static Performable clicOnContactUs(){
        return instrumented(Start.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(HomeItem.CONTACT_US_BTN));
    }
}
