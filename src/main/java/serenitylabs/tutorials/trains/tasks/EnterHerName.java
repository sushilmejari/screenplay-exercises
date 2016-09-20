package serenitylabs.tutorials.trains.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import serenitylabs.tutorials.trains.ui.AssistedTeavelPage;

/**
 * Created by smejari on 9/20/2016.
 */
public class EnterHerName implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    SelectFromOptions.byVisibleText("Dr").from(AssistedTeavelPage.TITLE)
            );
    }

    public static Performable as(String title,String firstName,String lastName)
    {
    return Instrumented.instanceOf(EnterHerName.class).withProperties(title,firstName,lastName);
    }



}
