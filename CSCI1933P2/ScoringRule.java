package CSCI1933P2;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.lang.annotation.Annotation;
import java.util.*;

public class ScoringRule implements TestRule {

    private String TEST_PREFIX = "Test";
    private String testedClassName;

    private Score overallScore;

    private Map<String, List<String>> categoryToTests;
    private Map<String, Score> categoryToScore;
    private Map<String, Score> testToScore;

    public ScoringRule(Class toTest) {
        testedClassName = toTest.getSimpleName();
        testedClassName = testedClassName.replaceAll(TEST_PREFIX, "");

        overallScore = new Score(0, 0);
        categoryToTests = new HashMap<>();
        categoryToScore = new HashMap<>();
        testToScore = new HashMap<>();
    }


    private void recordCategory(String category) {
        if (!categoryToTests.containsKey(category)) {
            categoryToTests.put(category, new ArrayList<>());
            categoryToScore.put(category, new Score(0, 0));
        }
    }

    private void recordTest(String testname, String category, int possiblePoints) {
        testToScore.put(testname, new Score(0, possiblePoints));

        List<String> tests = categoryToTests.get(category);
        tests.add(testname);

        Score categoryScore = categoryToScore.get(category);
        categoryScore.addToPossible(possiblePoints);

        overallScore.addToPossible(possiblePoints);
    }

    private void scoreEarnedPoints(String testname, String category, int earnedPoints) {
        Score testScore = testToScore.get(testname);
        testScore.addToEarned(earnedPoints);

        Score categoryScore = categoryToScore.get(category);
        categoryScore.addToEarned(earnedPoints);

        overallScore.addToEarned(earnedPoints);
    }

    @Override
    public String toString() {
        /**
         * Class name: earned / total       <-- overall score
         * BREAKDOWN:
         * Category_1: earned / possible    <-- category score
         *      Test_1: earned / possible   <-- test score
         *      Test_2: earned / possible
         * Category_2:
         *      Test_1: earned / possible
         */
        StringBuilder rubric = new StringBuilder();
        rubric.append(String.format("%s: %s\nBREAKDOWN:\n", testedClassName, overallScore.toString()));

        List<String> categories = new ArrayList<>(categoryToTests.keySet());
        Collections.sort(categories);

        for (String category : categories) {
            List<String> tests = categoryToTests.get(category);
            Score categoryScore = categoryToScore.get(category);
            rubric.append(String.format("%s: %s\n", category, categoryScore.toString()));

            for (String test : tests) {
                Score testScore = testToScore.get(test);
                rubric.append(String.format("\t%s: %s\n", test, testScore.toString()));
            }
        }
        return rubric.toString().trim();
    }

    @Override
    public Statement apply(final Statement baseStatement, final Description description) {
        final WorthPoints testPoints = description.getAnnotation(WorthPoints.class);
        final Category testCategory = description.getAnnotation(Category.class);

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                String category = testCategory == null ? "uncategorized" : testCategory.category();
                int points = testPoints == null ? 0 : testPoints.points();

                recordCategory(category);
                recordTest(description.getMethodName(), category, points);

                baseStatement.evaluate();

                // If evaluation didn't fail/throw an exception, points were earned
                scoreEarnedPoints(description.getMethodName(), category, points);
            }
        };
    }

    private class Score {
        private int earned;
        private int possible;

        Score(int earned, int possible) {
            this.earned = earned;
            this.possible = possible;
        }

        public int getEarned() {
            return earned;
        }

        public int getPossible() {
            return possible;
        }

        void addToEarned(int howMuch) {
            earned += howMuch;
        }

        void addToPossible(int howMuch) {
            possible += howMuch;
        }

        @Override
        public String toString() {
            return earned + "/" + possible;
        }
    }
}