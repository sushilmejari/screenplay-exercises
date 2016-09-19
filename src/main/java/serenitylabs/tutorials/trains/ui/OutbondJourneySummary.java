package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Created by smejari on 9/19/2016.
 */
public class OutbondJourneySummary {
    public static final Target ORIGIN=Target.the("Departure").locatedBy(".planner-header_origin");
    public static final Target DESTINATION=Target.the("Destination").locatedBy(".planner-header_destination");
}
