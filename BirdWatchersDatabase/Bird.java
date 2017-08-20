import java.util.Scanner;

/**
 * Created by Justin on 8/19/2017.
 */
public class Bird {

    //===================================================================================
    // Properties
    //===================================================================================

    private String name;
    private String latin_name;
    private int observations;

    //===================================================================================
    // Constructors
    //===================================================================================

    public Bird(String name, String latin_name) {
        this.name = name;
        this.latin_name = latin_name;
        this.observations = 0;
    }

    //===================================================================================
    // Accessors
    //===================================================================================

    public void setName(String name) {
        this.name = name;
    }

    public void setLatin_name(String latin_name) {
        this.name = latin_name;
    }

    public void observed() {
        this.observations++;
    }

    public String toString() {
        return name + " (" + latin_name + ")" + ": " + observations + " observations";
    }

    public String getName() {
        return name;
    }

    public String getLatin_name() {
        return latin_name;
    }

    public int getObservations() {
        return observations;
    }
}
