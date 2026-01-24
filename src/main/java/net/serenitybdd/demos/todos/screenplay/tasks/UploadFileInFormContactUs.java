package net.serenitybdd.demos.todos.screenplay.tasks;

import net.serenitybdd.demos.todos.screenplay.user_interface.ContactUsItem;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.actions.UploadToField;

import java.nio.file.Path;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UploadFileInFormContactUs implements Task {

    private final String routFile;

    public UploadFileInFormContactUs(String routFile) {
        this.routFile = routFile;
    }

    public static Performable uploadFileInForm(String routFile){
        return instrumented(UploadFileInFormContactUs.class, routFile);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Upload.theFile(Path.of(routFile)).to(ContactUsItem.UPLOAD_FILE),
                //Enter.theValue(routFile).into(ContactUsItem.UPLOAD_FILE),
                Scroll.to(ContactUsItem.UPLOAD_FILE)
        );
    }
}
