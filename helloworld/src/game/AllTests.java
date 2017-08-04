package game; /**
 * Created by katermar on 7/29/2017.
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AllTests{
    public static void main(String args[]) {
        Result result = JUnitCore.runClasses(GameOfLifeTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure);
        }

        System.out.print(result.wasSuccessful());
    }
}
