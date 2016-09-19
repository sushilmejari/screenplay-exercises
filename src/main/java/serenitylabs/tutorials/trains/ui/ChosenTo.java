package serenitylabs.tutorials.trains.ui;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import serenitylabs.tutorials.trains.model.MainMenu;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by smejari on 9/18/2016.
 */
public class ChosenTo implements Task{
    @Override
    public <T extends Actor> void performAs(T actor) {
actor.attemptsTo(
        Navigate.to(MainMenu.BuyTickets)
);
    }


    public static Performable bookATicket() {
        return instrumented(ChosenTo.class);
    }
}
