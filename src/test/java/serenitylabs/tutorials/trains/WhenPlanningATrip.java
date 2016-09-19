package serenitylabs.tutorials.trains;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenitylabs.tutorials.trains.questions.TheOutbondJourneySummary;
import serenitylabs.tutorials.trains.tasks.ViewTheAvailableTickets;
import serenitylabs.tutorials.trains.ui.ChosenTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class WhenPlanningATrip {
    @Managed
    WebDriver browser;
    Actor tracy;
    @Before
    public void setTheStage() {
        tracy = Actor.named("Tracy");
        tracy.can(BrowseTheWeb.with(browser));
        browser.manage().window().maximize();

    }

    @Test
    public void booking_a_simple_trip() {
//GIVEN
        tracy.has(ChosenTo.bookATicket());
        tracy.attemptsTo(
                ViewTheAvailableTickets.from("London Paddington").to("Oxford")
        );
        tracy.should(
                    seeThat("The Departure Station",TheOutbondJourneySummary.origin(),is("London Paddington")),
                seeThat("The Destination Station",TheOutbondJourneySummary.destination(),is("Oxford") )
        );


    }
}
