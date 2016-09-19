package serenitylabs.tutorials.trains.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import serenitylabs.tutorials.trains.ui.OutbondJourneySummary;

/**
 * Created by smejari on 9/19/2016.
 */
public class TheOutbondJourneySummary {


    public static Question<String> origin() {
        return actor -> Text.of(OutbondJourneySummary.ORIGIN)
                .viewedBy(actor).asString();
    }

    public static Question<String> destination() {
        return actor -> Text.of(OutbondJourneySummary.DESTINATION)
                .viewedBy(actor).asString();}

}
