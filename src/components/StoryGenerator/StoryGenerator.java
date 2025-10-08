package components.StoryGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 */
public final class StoryGenerator {

    /**
     * A map of categories and their corresponding elements stored in lists.
     */
    private final Map<String, List<String>> categoriesAndElements = new LinkedHashMap<>();

    /**
     * A map of templates and their corresponding order stored in lists.
     */
    private final Map<String, List<String>> templates = new HashMap<>();

    /**
     * A random object for randomly getting elements.
     */
    private final Random random = new Random();

    /**
     * The empty constructor.
     */
    public StoryGenerator() {
    }

    /**
     *
     * @param name
     *            the name of the template
     * @param order
     *            the order in which the elements are combined based on their
     *            categories
     */
    public void addTemplate(String name, List<String> order) {
        this.templates.put(name, order);
    }

    /**
     * Adds an element to the category.
     *
     * @param category
     *            The category the element belongs to
     * @param element
     *            The element to be added to category
     */
    public void addElement(String category, String element) {
        /*
         * If the category already exists, add the element to the corresponding
         * list; If not, add a new category and add the element to it.
         */
        if (this.categoriesAndElements.containsKey(category)) {
            this.categoriesAndElements.get(category).add(element);
        } else {
            List<String> elementList = new ArrayList<>();
            elementList.add(element);
            this.categoriesAndElements.put(category, elementList);
        }
    }

    /**
     * Generate plot by randomly obtaining element from the categories specified
     * in the template and combining them in the order specified by the
     * template.
     *
     * @param template
     *            The template of order used
     * @return A random plot generated according to the template of order.
     */
    public String generatePlot(String template) {
        List<String> order = this.templates.get(template);
        StringBuilder plot = new StringBuilder();
        /*
         * Randomly get elements from the category and append them in order
         */
        for (String category : order) {
            List<String> elements = this.categoriesAndElements.get(category);
            int index = this.random.nextInt(elements.size());
            plot.append(elements.get(index) + " ");
        }
        /*
         * trim the redundant space at the end of the string.
         */
        return plot.toString().trim();
    }
}
