import java.util.ArrayList;
import java.util.List;

import components.storygenerator.StoryGenerator;
import components.storygenerator.StoryGenerator1;

/**
 * A use case of StoryGenerator where it is used to randomly generate questions
 * for a quiz bank.
 */
public class QuizBank {

    /**
     * A StoryGenerator that stores quiz elements and structures.
     */
    private StoryGenerator quizData;

    /**
     * A list of quizzes stored in the order they were created.
     */
    private List<String> history;

    /**
     * Constructor: Initializes the quiz generator and loads base
     * numbers/operators.
     */
    public QuizBank() {
        this.quizData = new StoryGenerator1();
        this.history = new ArrayList<>();

    }

    /**
     * Adds a new quiz structure pattern (template).
     *
     * @param patternName
     *            The name of the new quiz structure.
     * @param structure
     *            The sequence of categories
     * @requires patternName is not in this.quizData.templates() and
     *           [{@code structure} is not null] and [patternName != null]
     * @ensures {@code patternName} is in this.quizData.templates() and
     *          [{@code structure}.equals(this.quizData.templateOrder({@code patterName}))]
     */
    public void addQuizStructure(String patternName, List<String> structure) {
        assert patternName != null : "Violation of: patternName != null.";
        assert !this.quizData.templates().contains(
                patternName) : "Violation of: patternName is not in this.quizData.templates().";
        assert structure != null : "Violation of: structure is not null.";

        this.quizData.addTemplate(patternName, structure);
    }

    /**
     * Adds a new element (e.g., a number or operator).
     *
     * @param elementType
     *            The type name.
     * @param elementValue
     *            The element to be added.
     * @requires {@code elementValue} is not null
     * @ensures {@code elementType} is in this.quizData.categories() and
     *          [this.quizData.elements(elementType).contains(elementValue)]
     */
    public void addQuestionElement(String elementType, String elementValue) {
        assert elementValue != null : "Violation of: elementValue is not null.";

        this.quizData.addElement(elementType, elementValue);
    }

    /**
     * Generates a randomized quiz question string and records it in history.
     *
     * @param patternName
     *            The name of the structure to generate the question from.
     * @requires {@code patternName} is in this.quizData.templates()
     * @return A generated question string.
     */
    public String generateRandomQuestion(String patternName) {
        assert this.quizData.templates().contains(
                patternName) : "Violation of: patternName is in this.quizData.templates().";
        String question = this.quizData.generatePlot(patternName);
        this.history.add(question);
        return question;
    }

    /**
     * Gets the sequence of all questions generated so far.
     *
     * @return a list of quizzes that have been generated.
     */
    public List<String> getGenerationHistory() {
        return this.history;
    }
}
