import java.util.List;
import java.util.Random;

import components.set.Set;
import components.set.Set1L;

/**
 * Layered implementations of secondary methods for {@code StoryGenerator}.
 */
public abstract class StoryGeneratorSecondary implements StoryGenerator {

    /*
     * Common methods from Object
     */

    /**
     * Returns a String representation of the StoryGenerator object.
     *
     * @return a String representation of this object
     * @ensures toString holds all the categories and the corresponding
     *          elements, as well as templates and the corresponding orders with
     *          their relationship shown clearly
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        /*
         * Append categories and elements
         */
        Set<String> categories = this.categories();
        result.append("Categories: ");
        for (String x : categories) {
            result.append(x + " ( ");
            List<String> elements = this.elements(x);
            for (String e : elements) {
                result.append("\"" + e + "\" ");
            }
            result.append(") ");
        }
        result.append("\n");
        /*
         * Append templates
         */
        Set<String> templates = this.templates();
        result.append("Templates: ");
        for (String x : templates) {
            result.append(x + " ( ");
            List<String> orders = this.templateOrder(x);
            for (String o : orders) {
                result.append("\"" + o + "\" ");
            }
            result.append(") ");
        }
        return result.toString();
    }

    /**
     * Returns true if this and s are the same; false otherwise.
     *
     * @param s
     *            the StoryGenerator object to be compared to this
     * @return true if this and s are the same; false otherwise.
     */
    public Boolean equals(StoryGenerator s) {
        /*
         * Check whether the categories are the same
         */
        Boolean result = this.categories().equals(s.categories());
        /*
         * If the categories equal, check whether the elements are the same
         */
        if (result) {
            for (String c : this.categories()) {
                /*
                 * The elements are stored in sorted lists. The following code
                 * put them in sets and compare whether they equal to each
                 * other.
                 */
                Set<String> elementsThis = new Set1L<>();
                Set<String> elementsS = new Set1L<>();
                for (String e : this.elements(c)) {
                    elementsThis.add(e);
                }
                for (String e : s.elements(c)) {
                    elementsS.add(e);
                }
                result = result && elementsThis.equals(elementsS);
            }
        }
        /*
         * If the categories and the elements equal, check whether the templates
         * are the same.
         */
        if (result) {
            result = result && this.templates().equals(s.templates());
        }
        if (result) {
            for (String c : this.templates()) {
                result = result
                        && this.templateOrder(c).equals(s.templateOrder(c));
            }
        }
        return result;
    }

    /*
     * Other non-kernel methods
     */

    /**
     * Generate plot by randomly obtaining element from the categories specified
     * in the template and combining them in the order specified by the
     * template.
     *
     * @param template
     *            The template of order used
     * @requires template is in this.templates
     * @return A random plot generated according to the template of order.
     *
     */
    public String generatePlot(String template) {
        assert this.templates().contains(
                template) : "Violation: template is in this.templates";

        Random random = new Random();
        String plot = "";
        /*
         * Get the order from the template
         */
        List<String> order = this.templateOrder(template);
        /*
         * Randomly get an element according to the order
         */
        for (String x : order) {
            List<String> elements = this.elements(x);
            plot = plot + elements.get(random.nextInt(elements.size())) + " ";
        }
        return plot.trim();
    }

    /**
     * Remove {@code category} in {@code this}.
     *
     * @param category
     *            the category to be cleared
     * @updates this
     * @requires {@code category} is in the set of categories in {@code this}
     * @ensure this = #this without the {@code category}
     */
    public void removeCategory(String category) {
        assert this.categories().indexOf(
                category) >= 0 : "Violation: category is in this.categories";

        List<String> elements = this.elements(category);
        for (String x : elements) {
            this.removeElement(category, x);
        }
    }

}
