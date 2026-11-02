package CSCI1933P3;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ScoringTestRule implements TestRule {
    private int points = 0;
    private int total = 0;

    public int getPoints() {
        return points;
    }

    public int getTotal() {
        return total;
    }

    private void addPoints(int points) {
        this.points += points;
    }

    private void addPointsToTotal(int points) {
        this.total += points;
    }

    @Override
    public Statement apply(final Statement baseStatement, final Description description) {
        final WorthPoints annotation = description.getAnnotation(WorthPoints.class);
        if (annotation == null) {
            return baseStatement;
        }

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                addPointsToTotal(annotation.points());
                baseStatement.evaluate();
                addPoints(annotation.points());
            }
        };
    }
}