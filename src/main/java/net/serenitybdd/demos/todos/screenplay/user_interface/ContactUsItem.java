package net.serenitybdd.demos.todos.screenplay.user_interface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ContactUsItem {
    public static Target NAME_FIELD = Target.the("name field").located(By.name("name"));
    public static Target EMAIL_FIELD = Target.the("email field").located(By.name("email"));
    public static Target SUBJECT_FIELD = Target.the("subject field").located(By.name("subject"));
    public static Target MESSAGE_FIELD = Target.the("message field").located(By.id("message"));
    public static Target UPLOAD_FILE = Target.the("upload file").located(By.name("upload_file"));
    public static Target SUBMIT_BTN = Target.the("submit btn").located(By.name("submit"));
    public static Target SUCCESS_MESSAGE = Target.the("success mesage").located(By.xpath("//div[normalize-space(text()) = 'Success! Your details have been submitted successfully.']"));
    public static Target HOME_BTN = Target.the("home btn").located(By.xpath("//a[@href='/']"));
}
