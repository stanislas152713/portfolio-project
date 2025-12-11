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
public class StoryGenerator1Test {

    /**
     * Tesst Constructor with arguments.
     */
    @Test
    public final void testConstructorWithArgument() {
        /*
         * Set up variables
         */
        Map<String, List<String>> categoriesMap = new HashMap<>();
        Map<String, List<String>> templatesMap = new HashMap<>();
        Set<String> categoriesSetReference = new HashSet<>();
        Set<String> templatesSetReference = new HashSet<>();
        List<String> elements = new ArrayList<>();
        List<String> order = new ArrayList<>();
        elements.add("Test");
        order.add("Character");
        categoriesMap.put("Character", elements);
        templatesMap.put("default", order);
        categoriesSetReference.add("Character");
        templatesSetReference.add("default");

        StoryGenerator s = new StoryGenerator1(categoriesMap, templatesMap);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(categoriesSetReference, s.categories());
        assertEquals(templatesSetReference, s.templates());
        assertEquals(elements, s.elements("Character"));
        assertEquals(order, s.templateOrder("default"));
    }

    /**
     * Test newInstance.
     */
    @Test
    public final void testNewInstance() {
        /*
         * Set up variables
         */
        StoryGenerator s = new StoryGenerator1();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(0, s.categories().size());
        assertEquals(0, s.templates().size());
    }

    /**
     * Test clear.
     */
    @Test
    public final void testClear() {
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

        StoryGenerator s = new StoryGenerator1(categoriesMap, templatesMap);
        /*
         * Call method under test
         */
        s.clear();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(0, s.categories().size());
        assertEquals(0, s.templates().size());
    }

    /**
     * Test transferFrom.
     */
    @Test
    public final void testTransferFrom() {
        /*
         * Set up variables
         */
        Map<String, List<String>> categoriesMap = new HashMap<>();
        Map<String, List<String>> templatesMap = new HashMap<>();
        Set<String> categoriesSetReference = new HashSet<>();
        Set<String> templatesSetReference = new HashSet<>();
        List<String> elements = new ArrayList<>();
        List<String> order = new ArrayList<>();
        elements.add("Test");
        order.add("Character");
        categoriesMap.put("Character", elements);
        templatesMap.put("default", order);
        categoriesSetReference.add("Character");
        templatesSetReference.add("default");

        StoryGenerator s1 = new StoryGenerator1(categoriesMap, templatesMap);
        StoryGenerator s2 = new StoryGenerator1();
        /*
         * Call method under test
         */
        s2.transferFrom(s1);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(0, s1.categories().size());
        assertEquals(0, s1.templates().size());
        assertEquals(categoriesSetReference, s2.categories());
        assertEquals(templatesSetReference, s2.templates());
        assertEquals(elements, s2.elements("Character"));
        assertEquals(order, s2.templateOrder("default"));
    }

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
     * Test addElement to a new category.
     */
    @Test
    public final void testAddElementToNewCategory() {
        /*
         * Set up variables
         */
        Set<String> categoriesSetReference = new HashSet<>();
        Set<String> templatesSetReference = new HashSet<>();
        List<String> elementsReference = new ArrayList<>();
        elementsReference.add("John");
        categoriesSetReference.add("Character");
        templatesSetReference.add("default");

        StoryGenerator s = new StoryGenerator1();
        /*
         * Call method under test
         */
        s.addElement("Character", "John");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(categoriesSetReference, s.categories());
        assertEquals(elementsReference, s.elements("Character"));
        assertEquals(0, s.templates().size());
    }

    /**
     * Test addElement to an existing category.
     */
    @Test
    public final void testAddElementToExistingCategory() {
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

        elementsReference.add("John");
        /*
         * Call method under test
         */
        s.addElement("Character", "John");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(categoriesSetReference, s.categories());
        assertEquals(elementsReference, s.elements("Character"));
        assertEquals(templatesSetReference, s.templates());
        assertEquals(order, s.templateOrder("default"));
    }

    /**
     * Test addElement with duplicate element in the category.
     */
    @Test
    public final void testAddElementDuplicateElement() {
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

        elementsReference.add("Kenny");
        /*
         * Call method under test
         */
        s.addElement("Character", "Kenny");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(categoriesSetReference, s.categories());
        assertEquals(elementsReference, s.elements("Character"));
        assertEquals(templatesSetReference, s.templates());
        assertEquals(order, s.templateOrder("default"));
    }

    /**
     * Test addTemplate.
     */
    @Test
    public final void testAddTemplate() {
        /*
         * Set up variables
         */
        Set<String> templatesSetReference = new HashSet<>();
        List<String> orderReference = new ArrayList<>();
        orderReference.add("Character");
        templatesSetReference.add("default");

        StoryGenerator s = new StoryGenerator1();
        /*
         * Call method under test
         */
        s.addTemplate("default", orderReference);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(0, s.categories().size());
        assertEquals(templatesSetReference, s.templates());
        assertEquals(orderReference, s.templateOrder("default"));
    }

    /**
     * Test categories on a StoryGenerator with 1 or more categories.
     */
    @Test
    public final void testCategoriesNonEmpty() {
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
        /*
         * Call method under test
         */
        Set<String> c = s.categories();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(categoriesSetReference, c);
        assertEquals(elementsReference, s.elements("Character"));
        assertEquals(templatesSetReference, s.templates());
        assertEquals(order, s.templateOrder("default"));
    }

    /**
     * Test categories on a StoryGenerator with 0 category.
     */
    @Test
    public final void testCategoriesEmpty() {
        /*
         * Set up variables
         */
        StoryGenerator s = new StoryGenerator1();
        /*
         * Call method under test
         */
        Set<String> c = s.categories();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(0, c.size());
        assertEquals(0, s.templates().size());
    }

    /**
     * Test templates on a StoryGenerator with 1 or more templates.
     */
    @Test
    public final void testTemplatesNonEmpty() {
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
        /*
         * Call method under test
         */
        Set<String> t = s.templates();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(categoriesSetReference, s.categories());
        assertEquals(elementsReference, s.elements("Character"));
        assertEquals(templatesSetReference, t);
        assertEquals(order, s.templateOrder("default"));
    }

    /**
     * Test templates on a StoryGenerator with 0 template.
     */
    @Test
    public final void testTemplatesEmpty() {
        /*
         * Set up variables
         */
        StoryGenerator s = new StoryGenerator1();
        /*
         * Call method under test
         */
        Set<String> t = s.templates();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(0, s.categories().size());
        assertEquals(0, t.size());
    }

    /**
     * Test removeElement from a category containing one element.
     */
    @Test
    public final void testRemoveElementFromSize1() {
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
        /*
         * Call method under test
         */
        s.removeElement("Character", "Kenny");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(0, s.categories().size());
        assertEquals(templatesSetReference, s.templates());
        assertEquals(order, s.templateOrder("default"));
    }

    /**
     * Test removeElement from a category containing more than one elements.
     */
    @Test
    public final void testRemoveElementFromSizeMany() {
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
        elementsReference.add("Lu");
        order.add("Character");
        categoriesMap.put("Character", elementsReference);
        templatesMap.put("default", order);
        categoriesSetReference.add("Character");
        templatesSetReference.add("default");

        StoryGenerator s = new StoryGenerator1(categoriesMap, templatesMap);
        /*
         * Call method under test
         */
        s.removeElement("Character", "Kenny");
        elementsReference.remove("Lu");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(categoriesSetReference, s.categories());
        assertEquals(elementsReference, s.elements("Character"));
        assertEquals(templatesSetReference, s.templates());
        assertEquals(order, s.templateOrder("default"));
    }

    /**
     * Test templateOrder.
     */
    @Test
    public final void testTemplateOrder() {
        /*
         * Set up variables
         */
        Map<String, List<String>> categoriesMap = new HashMap<>();
        Map<String, List<String>> templatesMap = new HashMap<>();
        Set<String> categoriesSetReference = new HashSet<>();
        Set<String> templatesSetReference = new HashSet<>();
        List<String> elementsReference = new ArrayList<>();
        List<String> orderReference = new ArrayList<>();
        elementsReference.add("Kenny");
        orderReference.add("Character");
        categoriesMap.put("Character", elementsReference);
        templatesMap.put("default", orderReference);
        categoriesSetReference.add("Character");
        templatesSetReference.add("default");

        StoryGenerator s = new StoryGenerator1(categoriesMap, templatesMap);
        /*
         * Call method under test
         */
        List<String> order = s.templateOrder("default");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(categoriesSetReference, s.categories());
        assertEquals(elementsReference, s.elements("Character"));
        assertEquals(templatesSetReference, s.templates());
        assertEquals(orderReference, order);
    }

    /**
     * Test removeTemplate.
     */
    @Test
    public final void testRemoveTemplate() {
        /*
         * Set up variables
         */
        Map<String, List<String>> categoriesMap = new HashMap<>();
        Map<String, List<String>> templatesMap = new HashMap<>();
        Set<String> categoriesSetReference = new HashSet<>();
        Set<String> templatesSetReference = new HashSet<>();
        List<String> elementsReference = new ArrayList<>();
        List<String> orderReference = new ArrayList<>();
        elementsReference.add("Kenny");
        orderReference.add("Character");
        categoriesMap.put("Character", elementsReference);
        templatesMap.put("default", orderReference);
        categoriesSetReference.add("Character");
        templatesSetReference.add("default");

        StoryGenerator s = new StoryGenerator1(categoriesMap, templatesMap);
        templatesSetReference.remove("default");
        /*
         * Call method under test
         */
        List<String> templateRemoved = s.removeTemplate("default");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(categoriesSetReference, s.categories());
        assertEquals(elementsReference, s.elements("Character"));
        assertEquals(templatesSetReference, s.templates());
        assertEquals(orderReference, templateRemoved);
    }
}
