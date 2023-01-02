package datatest;
import data.Goal;
import data.exceptions.NullGoalTypeException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GoalTest {
    @Test
    void testNullThrowsNullGoalTypeException(){
        Goal goal = new Goal(null);
        Throwable exception = assertThrows(NullGoalTypeException.class, goal::getGoalType);
        assertEquals("The goal type is null", exception.getMessage());
    }
}
