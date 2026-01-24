package net.serenitybdd.demos.todos.screenplay.user_interface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class HomeItem {

    public static Target CONTACT_US_BTN =  Target.the("contact us button")
            .located(By.xpath("//a[@href='/contact_us']"));
}