package serenitylabs.tutorials.trains;

/**
 * Created by smejari on 9/21/2016.
 */
public enum Checker {

    EMPTY ("Empty"),
    RED ("Red"),
    YELLOW ("Yellow");

    private Checker(String value){
        this.value = value;
    }

    private final String value;

    public String getValue(){return value;}

}
