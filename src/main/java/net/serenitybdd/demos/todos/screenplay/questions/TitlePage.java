package net.serenitybdd.demos.todos.screenplay.questions;

//import net.serenitybdd.demos.todos.screenplay.model.TodoStatus;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

//@Subject("The item status for '#itemName'")
public class TitlePage implements Question<String> {

    // Constructor que toma el selector del título
    public static TitlePage of() {
        return new TitlePage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).getTitle();
    }
}