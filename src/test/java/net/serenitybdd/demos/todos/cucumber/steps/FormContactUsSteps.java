package net.serenitybdd.demos.todos.cucumber.steps;


import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.demos.todos.screenplay.questions.SuccessMessage;
import net.serenitybdd.demos.todos.screenplay.questions.TitlePage;
import net.serenitybdd.demos.todos.screenplay.tasks.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.Matchers.equalTo;

public class FormContactUsSteps {

    @Before
    public void set_the_stage() {
        setTheStage(new OnlineCast());
    }

    @ParameterType(".*")
    public Actor actor(String actor) {
        return OnStage.theActorCalled(actor);
    }

    @Given("{actor} abre el navegador")
    public void abre_el_navegador(Actor actor) {
        actor.wasAbleTo(Start.openBrowser());
    }

    @Then("{actor} navega a la url y valida que el titulo sea visible")
    public void navega_a_la_url_y_valida_que_el_titulo_sea_visible(Actor actor) {
        actor.should(seeThat("El título es visible", TitlePage.of(), equalTo("Automation Exercise")));
    }

    @And("{actor} da clic en el botón Contact us")
    public void da_clic_en_el_botón_Contact_us(Actor actor) {
        actor.attemptsTo(
                Start.clicOnContactUs()
        );
    }

    @When("{actor} Llena los campos obligatorios Name, Email, Subject, Message")
    public void Llena_los_campos_obligatorios_Name_Email_Subject_Message(Actor actor){

        actor.attemptsTo(
                FillFormContactUs.sendMessageInForm(Serenity.environmentVariables().getProperty("form.name"),
                        Serenity.environmentVariables().getProperty("form.email"), Serenity.environmentVariables().getProperty("form.subject"),
                        Serenity.environmentVariables().getProperty("form.message"))

        );
    }

    @And("Realiza la carga de un archivo 'Upload File'")
    public void realizar_la_carga_de_un_archivo_Upload_File(){
        theActorCalled("Usuario").attemptsTo(
                UploadFileInFormContactUs.uploadFileInForm(Serenity.environmentVariables().getProperty("form.routFile"))
        );
    }

    @And("Envía el formulario y aceptar las alertas del navegador")
    public void Envia_el_formulario_y_aceptar_las_alertas_del_navegador(){
        theActorCalled("Usuario").attemptsTo(SendFormAndAcceptAlerts.sendFormAcceptAlert());

        //Aceptar alerta
        Serenity.getDriver().switchTo().alert().accept();
    }

    @Then("Validar el mensaje de éxito {string}")
    public void validar_el_mensaje_de_éxito(String mensaje){
        theActorCalled("Usuario").should(seeThat("Mensaje de exito visible", SuccessMessage.success(), equalTo(mensaje)));
    }

    @And("Regresa al home")
    public void regresa_al_home(){
        theActorCalled("Usuario").attemptsTo(BackToHome.toHome());
    }
}
