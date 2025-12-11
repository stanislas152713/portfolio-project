package components.storygenerator;

/**
 * {@code StoryGeneratorKernel} enhanced with secondary methods.
 */
public interface StoryGenerator extends StoryGeneratorKernel {
    /**
     * Generate plot by randomly obtaining element from the categories specified
     * in the template and combining them in the order specified by the
     * template.
     *
     * @param template
     *            The template of order used
     * @return A random plot generated according to the template of order.
     *
     */
    String generatePlot(String template);

    /**
     * Generate plot by randomly obtaining element from the categories specified
     * in the template and combining them in the order specified by the
     * template.
     *
     * @param template
     *            The template of order used
     * @param seed
     *            The seed for the random object
     * @return A random plot generated according to the template of order.
     *
     */
    String generatePlot(String template, Long seed);

    /**
     * Remove {@code category} in {@code this}.
     *
     * @param category
     *            the category to be cleared
     * @updates this
     * @requires {@code category} is in the set of categories in {@code this}
     * @ensure this = #this without the {@code category}
     */
    void removeCategory(String category);

}
