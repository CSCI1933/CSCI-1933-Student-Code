import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Random;
import static org.junit.Assert.*;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

/**
 * JUnit Test Written By Henry Dinh on 10.29.2021 for CSCI 1933 Lab 10
 * JUnit 4
 */

//Do not modify
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface WorthPoints {
    int points();
}

//This class represents Lab10 milestone tests
//Do Not Modify
@FixMethodOrder(NAME_ASCENDING)
public class Lab10Tests {
    private static final ScoringTestRule SCORING_TEST_RULE = new ScoringTestRule();
    @Rule
    public ScoringTestRule scoringTestRule = SCORING_TEST_RULE;
    @Rule
    public Timeout globalTimeOut = Timeout.seconds(15);

    @AfterClass
    public static void printScore() {
        System.out.println();
        System.out.println("Lab 10 score: " + SCORING_TEST_RULE.getPoints() + " / " + SCORING_TEST_RULE.getTotal() + " points");
        if (SCORING_TEST_RULE.getPoints() == 5)
            System.out.println("\nYou are all done with lab!");
        else{
            System.out.println("\nNot quite.. keep going!");
        }
    }

    @Test
    @WorthPoints(points = 1)
    public void exceptionCheck (){
        for (int i = 0 ; i<10; i++){
            StackException obj = new StackException(i);
            assertEquals(obj.getSize(), i);
        }
    }

    // ------------ Comment this back in for Milestone 2 ------------
//    @Test
//    @WorthPoints(points = 1)
//    public void pushEdgeCase(){
//        try{
//            Stack<Integer> obj = new Stack<>(1);
//            obj.push(1);
//            obj.push(2);
//
//        }catch(StackException e){
//            System.out.println("Correctly Thrown Exception for push()");
//        }
//    }
//
//    @Test
//    @WorthPoints(points = 1)
//    public void popEdgeCase(){
//        try {
//            Stack<Integer> obj = new Stack<>(1);
//            obj.pop();
//        }catch (StackException e){
//            System.out.println("\nCorrectly Thrown Exception for pop()");
//        }
//    }
//
//
//    @Test
//    @WorthPoints(points = 1)
//    public void stackCheck(){
//        //run 1000 tests
//        try {
//            for (int i = 0; i < 1000; i++) {
//                Stack<Character> obj = new Stack<>(10);
//
//
//                Character[] test = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
//                Character[] comparison = new Character[10];
//                Random a = new Random();
//
//                for (int j = 0; j < 10; j++) {
//                    int index = a.nextInt(test.length);
//                    obj.push(test[index]);
//                    comparison[j] = test[index];
//                }
//
//                for (int q = comparison.length - 1; q >= 0; q--) { //Checking comparison array with the stack elements
//                    assertEquals(comparison[q], obj.pop());
//                }
//            }
//        }
//        catch (StackException e){}
//
//    }


    // ------------ Comment this back in for Milestone 3 ------------
//    @Test
//    @WorthPoints(points = 1)
//    public void postFix(){
//        String[] test1 = {"5", "2", "+"};
//        String[] test2 = {"1", "2", "-"};
//        String[] test3 = {"4", "5", "*", "3", "+"};
//        String[] test4 = {"1", "2", "+", "3", "4", "+", "/"};
//        String[] test5 = {"1","2","3","4","5","6","7", "-"};
//        String[] test6 = {"1","2","3","4","5","6","7", "8"};
//        String[] test7 = {"1","2","+","4","5","-", "/", "/"};
//        String[] test8 = {"1", "4", "-", "3", "4", "+", "/"};
//
//
//        assertTrue(Postfix.evaluate((test1)) == 7.0);
//        assertTrue(Postfix.evaluate((test2)) == -1.0);
//        assertTrue(Postfix.evaluate((test3)) == 23.0);
//        assertTrue(Postfix.evaluate((test4)) == 0.42857142857142855);
//        assertTrue(Postfix.evaluate(test5) == 0.0);
//        assertTrue(Postfix.evaluate(test6) == 0.0);
//        assertTrue(Postfix.evaluate(test7) == 0.0);
//        assertTrue(Postfix.evaluate(test8) == -0.42857142857142855);
//    }

}

//Do not modify
class ScoringTestRule implements TestRule {
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
