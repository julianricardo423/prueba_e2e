package net.serenitybdd.demos.todos.screenplay.questions;

import net.serenitybdd.demos.todos.screenplay.user_interface.ContactUsItem;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SuccessMessage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return ContactUsItem.SUCCESS_MESSAGE.resolveFor(actor).getText();
    }

    public static SuccessMessage success() {
        return new SuccessMessage();
    }
}
