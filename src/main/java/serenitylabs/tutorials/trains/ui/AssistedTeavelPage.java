package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Created by smejari on 9/20/2016.
 */
public class AssistedTeavelPage extends PageObject{


    public static final Target TITLE= Target.the("title").locatedBy("//div[label[contains(.,'Title')]]/select");
    public static final Target FULL_NAME = Target.the("first name").locatedBy("//div[label[contains(.,'Full name')]]/input");

}
