package serenitylabs.tutorials.trains.ui;


import gherkin.lexer.Id;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;

/**
 * Created by smejari on 9/19/2016.
 */
public class TicketTypeForm {

public static Target FROM = Target.the("Departure station").located(By.id("depart-from"));
    public static Target TO = Target.the("Destination station").locatedBy("#going-to");
    public static Target BUY_TICKETS=Target.the("Buy tickets").locatedBy(".planner__submit");


}

