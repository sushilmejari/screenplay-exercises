package serenitylabs.tutorials.trains;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenitylabs.tutorials.trains.questions.TheOutboundJourneySummary;
import serenitylabs.tutorials.trains.tasks.ChosenTo;
import serenitylabs.tutorials.trains.tasks.EnterHerDetails;
import serenitylabs.tutorials.trains.tasks.ViewTheAvailableTickets;
import serenitylabs.tutorials.trains.ui.AssistedTravelPage;
import serenitylabs.tutorials.trains.ui.TicketTypeForm;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isSelected;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.questions.targets.TheTarget.valueOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(SerenityRunner.class)
public class WhenPlanningATrip {

    @Managed
    WebDriver webDriver;

    Actor tracy;

    @Before
    public void setTheStage() {
        tracy = Actor.named("Tracy");
        tracy.can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
    }

    @Test
    public void booking_a_simple_trip() {

        tracy.has(ChosenTo.bookATicket());

        // WHEN
        tracy.attemptsTo(
                ViewTheAvailableTickets.from("London Paddington").to("Oxford")
        );

        // THEN
        tracy.should(
                seeThat(TheOutboundJourneySummary.origin(), is("London Paddington")),
                seeThat(TheOutboundJourneySummary.destination(), is("Oxford"))
        );
    }

    @Test
    public void sensible_default_trip_options_are_proposed() {
        tracy.has(ChosenTo.bookATicket());
        // TODO
        tracy.should(
                seeThat(WebElementQuestion.the(TicketTypeForm.HEADING), WebElementStateMatchers.isVisible()),
                seeThat(WebElementQuestion.the(TicketTypeForm.HEADING), containsText("Buy ticket")),

                seeThat(WebElementQuestion.the(TicketTypeForm.SINGLE), isSelected()),
                seeThat(WebElementQuestion.the(TicketTypeForm.SINGLE), isEnabled()),
                seeThat(WebElementQuestion.the(TicketTypeForm.RETURN), not(isSelected())),
                seeThat(TheTarget.attributeNamed("placeholder").forTarget(TicketTypeForm.FROM),equalTo("From"))
                );
    }

    @Test
    public void return_date_should_be_only_enabled_for_return_trips() {
        tracy.has(ChosenTo.bookATicket());
        // TODO
    }


    @Test
    public void request_assisted_travel() {
        tracy.has(ChosenTo.requestAssistedTravel());
        tracy.attemptsTo(EnterHerDetails.as("Dr", "Tracy", "Traveller"));

        tracy.should(
                seeThat(valueOf(AssistedTravelPage.FULL_NAME),is("Tracy Traveller")),
                seeThat(valueOf(AssistedTravelPage.TITLE),is("Dr"))
        );

        // TODO
    }


}
