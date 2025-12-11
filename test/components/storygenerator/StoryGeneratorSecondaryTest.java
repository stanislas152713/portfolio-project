package components.storygenerator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Test cases for the abstract class.
 */
public class StoryGeneratorSecondaryTest {

    /**
     * Test toString on a StoryGenerator with categories and templates.
     */
    @Test
    public final void testToStringNonEmpty() {
        /*
         * Set up variables
         */
        Map<String, List<String>> categoriesMap = new HashMap<>();
        Map<String, List<String>> templatesMap = new HashMap<>();
        List<String> elements = new ArrayList<>();
        List<String> order = new ArrayList<>();
        elements.add("Kenny");
        order.add("Character");
        categoriesMap.put("Character", elements);
        templatesMap.put("default", order);

        StoryGenerator s = new StoryGenerator1(categoriesMap, templatesMap);

        final String expected = "Categories: Character ( \"Kenny\" ) \n"
                + "Templates: default ( \"Character\" ) ";

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expected, s.toString());
    }

    /**
     * Test toString on an empty StoryGenerator.
     */
    @Test
    public final void testToStringEmpty() {
        /*
         * Set up variables
         */
        StoryGenerator s = new StoryGenerator1();

        final String expected = "Categories: \nTemplates: ";

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expected, s.toString());
    }

    /**
     * Test equals on two identical StoryGenerator objects.
     */
    @Test
    public final void testEqualsTrue() {
        /*
         * Set up variables
         */
        Map<String, List<String>> categoriesMap = new HashMap<>();
        Map<String, List<String>> templatesMap = new HashMap<>();
        List<String> elements = new ArrayList<>();
        List<String> order = new ArrayList<>();
        elements.add("Test");
        order.add("Character");
        categoriesMap.put("Character", elements);
        templatesMap.put("default", order);

        StoryGenerator s1 = new StoryGenerator1(categoriesMap, templatesMap);
        StoryGenerator s2 = new StoryGenerator1(categoriesMap, templatesMap);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(true, s1.equals(s2));
    }

    /**
     * Test equals where the order of categories in a template is different.
     */
    @Test
    public final void testEqualsFalse() {
        /*
         * Set up variables
         */
        Map<String, List<String>> categoriesMap = new HashMap<>();
        Map<String, List<String>> templatesMap = new HashMap<>();
        List<String> elements = new ArrayList<>();
        List<String> order = new ArrayList<>();
        elements.add("Test");
        order.add("Character");
        categoriesMap.put("Character", elements);
        templatesMap.put("default", order);
        StoryGenerator s1 = new StoryGenerator1();
        StoryGenerator s2 = new StoryGenerator1(categoriesMap, templatesMap);
        /*
         * Assert that values of variables match expectations (False because
         * Lists are compared)
         */
        assertEquals(false, s1.equals(s2));
    }

    /**
     * Test generatePlot. Since the output is random, the test runs the method
     * 1000 times and test whether all possible elements have occurred. Whether
     * the output follows the order can be tested
     */
    @Test
    public final void testGeneratePlot() {
        /*
         * Set up variables
         */
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
         * Call the method under test 1000 times and store the results in a set
         */
        Set<String> output = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            output.add(x.generatePlot("preset"));
        }

        Set<String> elementsToCheck = new HashSet<>();
        for (String category : x.templateOrder("preset")) {
            for (String element : x.elements(category)) {
                elementsToCheck.add(element);
            }
        }
        String combinedOutput = String.join(" ", output);

        Boolean allFound = true;
        for (String element : elementsToCheck) {
            if (!combinedOutput.contains(element)) {
                allFound = false;
                break;
            }
        }
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(true, allFound);
    }

    /**
     * Test removeCategory.
     */
    @Test
    public final void testRemoveCategory() {
        /*
         * Set up variables
         */
        Map<String, List<String>> categoriesMap = new HashMap<>();
        Map<String, List<String>> templatesMap = new HashMap<>();
        Set<String> categoriesSetReference = new HashSet<>();
        Set<String> templatesSetReference = new HashSet<>();
        List<String> elementsReference = new ArrayList<>();
        List<String> order = new ArrayList<>();
        elementsReference.add("Kenny");
        order.add("Character");
        categoriesMap.put("Character", elementsReference);
        templatesMap.put("default", order);
        categoriesSetReference.add("Character");
        templatesSetReference.add("default");

        StoryGenerator s = new StoryGenerator1(categoriesMap, templatesMap);

        categoriesSetReference.remove("Character");
        /*
         * Call method under test
         */
        s.removeCategory("Character");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(categoriesSetReference, s.categories());
        assertEquals(templatesSetReference, s.templates());
        assertEquals(order, s.templateOrder("default"));

    }
}
