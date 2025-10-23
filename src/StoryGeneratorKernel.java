import java.util.List;

import components.set.Set;
import components.standard.Standard;

/**
 * Story generator kernel component with primary methods.
 *
 * Story Generator allows users to add elements to categories and can generate a
 * random cobination of elements, each from a certain category, in a certain
 * order.
 */
public interface StoryGeneratorKernel extends Standard<StoryGenerator> {
    /**
     * Adds {@code element} to {@code category} in {@code this}.
     *
     * @param category
     *            the category to which the {@code thi} is added
     * @param element
     *            the {@code String} to be added this
     * @updates this
     * @requires category.is_not_empty and [element is not in #this.categories]
     * @ensures this = #this + [element in categoty]
     */
    void addElement(String category, String element);

    /**
     * Adds the template named {@code name} containing {@code order} to
     * {@code this}.
     *
     * @param name
     *            the name of the template
     * @param order
     *            the order in which the story is generated.
     * @updates #this
     * @requires order.is_not_empty and name.is_not_empty and {name is not in
     *           #this.templates}
     * @ensures this.templates = #this.templates + [the template named
     *          {@code name} containing {@code order}]
     */
    void addTemplate(String name, List<String> order);

    /**
     * Returns a set of all category names in {@code this}.
     *
     * @return the set of categories
     * @ensures categories include all categories in {@code this}.
     */
    Set<String> categories();

    /**
     * Returns a list of all elements in the given {@code category} of
     * {@code this}.
     *
     * @param category
     *            the category whose elements are to be returned
     * @return the list of elements in {@code category} in {@code this}
     * @requires {@code category} is the categories in {@code this}
     * @ensures elements include [all elements in {@code category} in
     *          {@code this}].
     */
    List<String> elements(String category);

    /**
     * Removes {@code element} from {@code category} in {@code this}.
     *
     * @param category
     *            the category from which the element is removed
     * @param element
     *            the element to be removed
     * @updates this
     * @requires {@code category} is in the set of categories in {@code this}
     *           and {@code element} is in {@code category}
     * @ensures this = #this without {@code element} in {@code category}
     */
    void removeElement(String category, String element);

    /**
     * Returns the ordered list of categories that constitute the template named
     * {@code name} in {@code this}.
     *
     * @param name
     *            the name of the template
     * @return the ordered list of categories
     * @requires the template named {@code name} is in {@code this}
     * @ensures templateOrder = the ordered list of categories in
     *          #this.template.name
     */
    List<String> templateOrder(String name);

    /**
     * Removes the template named {@code name} from {@code this} and returns its
     * ordered list of categories.
     *
     * @param name
     *            the name of the template to be removed
     * @return the ordered list of categories stored in the removed template
     * @updates this
     * @requires the template named {@code name} is in {@code this}
     * @ensures this = #this without the template named {@code name} in
     *          {@code #this}.
     */
    List<String> removeTemplate(String name);

    /**
     * Returns a set of the names of all templates currently stored in
     * {@code this}.
     * @return a set containing the names of all templates
     * @ensures templates include all template names in {@code this}
     */
    Set<String> templates();
}
