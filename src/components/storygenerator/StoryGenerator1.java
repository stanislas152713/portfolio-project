package components.storygenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Story generator kernel component with primary methods.
 *
 * @correspondence <pre>
 * this = (category_library, template_library)
 * where
 * category_library = this.categories and
 * template_library = this.templates
 * </pre>
 * @convention <pre>
 * this.templates /= null and
 * this.categories /= null and
 * all keys and values in maps and their internal lists /= null
 * </pre>
 */
public class StoryGenerator1 extends StoryGeneratorSecondary {
    /*
     * private members
     */

    /**
     * A map that matches templates to order.
     */
    private Map<String, List<String>> templates;

    /**
     * A map that matches categories with elements.
     */
    private Map<String, List<String>> categories;

    /**
     * Createor of initial representation.
     */
    private void createNewRep() {
        this.templates = new HashMap<>();
        this.categories = new HashMap<>();
    }

    /**
     * No-argument constructor.
     */
    public StoryGenerator1() {
        this.createNewRep();
    }

    /**
     * Constructor that uses the 2 paramters as templates and categories.
     *
     * @param templates
     *            Templates of order
     * @param categories
     *            Categories of elements
     */
    public StoryGenerator1(Map<String, List<String>> categories,
            Map<String, List<String>> templates) {
        this.templates = templates;
        this.categories = categories;
    }

    /*
     * Standard methods
     */

    @Override
    public final StoryGenerator newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(StoryGenerator source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof StoryGenerator1 : ""
                + "Violation of: source is of dynamic type SimpleWriter1L";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        StoryGenerator1 localSource = (StoryGenerator1) source;
        this.categories = localSource.categories;
        this.templates = localSource.templates;
        localSource.createNewRep();
    }

    /*
     * Kernel methods
     */

    @Override
    public final void addElement(String category, String element) {
        assert category != null : "Violation of: category is not null";
        assert element != null : "Violation of: element is not null";

        if (!this.categories.containsKey(category)) {
            this.categories.put(category, new ArrayList<>());
        }
        this.categories.get(category).add(element);
    }

    @Override
    public final void addTemplate(String name, List<String> order) {
        assert name != null : "Violation of: name is not null";
        assert order != null : "Violation of: order is not null";
        assert !this.templates.containsKey(
                name) : "Violation of: name is not in this.templates";

        List<String> l = new ArrayList<>();
        for (String x : order) {
            l.add(x);
        }
        this.templates.put(name, l);
    }

    @Override
    public final Set<String> categories() {
        return this.categories.keySet();
    }

    @Override
    public final List<String> elements(String category) {
        return this.categories.get(category);
    }

    @Override
    public final void removeElement(String category, String element) {
        assert this.categories.containsKey(
                category) : "Violation of: category is in this.categories";
        assert this.categories.get(category)
                .contains(element) : "Violation of: element is in category";

        this.categories.get(category).remove(element);
        if (this.categories.get(category).size() == 0) {
            this.categories.remove(category);
        }
    }

    @Override
    public final List<String> templateOrder(String name) {
        assert this.templates
                .containsKey(name) : "Violation of: name is in this.templates";

        return this.templates.get(name);
    }

    @Override
    public final List<String> removeTemplate(String name) {
        assert this.templates
                .containsKey(name) : "Violatio of: name is in this.templates";

        return this.templates.remove(name);
    }

    @Override
    public final Set<String> templates() {
        return this.templates.keySet();
    }
}
