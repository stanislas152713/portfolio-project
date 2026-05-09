
import java.util.ArrayList;
import java.util.List;

import components.storygenerator.StoryGenerator;
import components.storygenerator.StoryGenerator1;

/**
 * A demo of StoryGenerator.
 */
public final class Demo {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Demo() {
    }

    /**
     * The main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        StoryGenerator x = new StoryGenerator1();
        List<String> presetTemplate = new ArrayList<>();

        /*
         * Create the preset template for order
         */
        presetTemplate.add("Character");
        presetTemplate.add("Action");
        presetTemplate.add("Setting");
        x.addTemplate("preset", presetTemplate);

        /*
         * Add elements to character
         */
        x.addElement("Character", "Kurt Cobain");
        x.addElement("Character", "Axl Rose");
        x.addElement("Character", "Damon Albarn");
        x.addElement("Character", "Mariah Carey");
        x.addElement("Character", "JoJo Siwa");

        /*
         * Add elements to action
         */
        x.addElement("Action", "sings Bette Davis Eyes");
        x.addElement("Action", "sings Parklife");
        x.addElement("Action", "sings Touch My Body");
        x.addElement("Action", "sings Smells Like Teen Spirit");
        x.addElement("Action", "sings All I Want For Christmas Is You");
        x.addElement("Action", "sings Sweet Child O' Mine");

        /*
         * Add elements to setting
         */
        x.addElement("Setting", "in heaven");
        x.addElement("Setting", "at Christmas");
        x.addElement("Setting", "in The J team");
        x.addElement("Setting", "in A Quiet Place");

        /*
         * Print the plot
         */
        System.out.print(x.generatePlot("preset"));
    }
}
