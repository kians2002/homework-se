import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciseGroupManagerTest {
    /**
     * Tests the checkGroupCapacities method of ExerciseGroupManager for the case where the total number of students
     * can be evenly distributed among the available groups.
     *
     * The test initializes the ExerciseGroupManager and checks if 30 students can be evenly divided
     * into 3 groups, each with a capacity of 10 students. The expected result is zero, indicating that
     * there is no overcapacity.
     *
     * The expected output is verified using an assertion to ensure the actual result matches the expected outcome.
     */
    @Test
    public void testCheckGroupCapacities_NormalCaseEqualDistribution() {
        ExerciseGroupManager manager = new ExerciseGroupManager();
        int result = manager.checkGroupCapacities(30, 10, 3);
        assertEquals(0, result);
    }

    /**
     * Tests the checkGroupCapacities method of ExerciseGroupManager for the case where the total number of students is zero.
     *
     * The test initializes the ExerciseGroupManager and checks if the method correctly handles the scenario
     * where there are no students to assign to groups. The group size and number of available groups are
     * provided as parameters but are irrelevant in this case since there are no students.
     *
     * The expected result is zero, indicating that there is no overcapacity since there are no students to assign.
     * The result is verified using an assertion to ensure the actual result matches the expected outcome.
     */
    @Test
    public void testCheckGroupCapacities_TotalStudentsZero() {
        ExerciseGroupManager manager = new ExerciseGroupManager();
        int result = manager.checkGroupCapacities(0, 10, 3);
        assertEquals(0, result);
    }

    /**
     * Tests the checkGroupCapacities method of ExerciseGroupManager for the case where the group size is zero.
     *
     * The test initializes the ExerciseGroupManager and checks if the method correctly handles the scenario
     * where the group size is zero, which is an invalid input. The method is expected to throw an
     * IllegalArgumentException in this case to indicate that the group size must be greater than zero.
     *
     * This behavior is verified using assertThrows to ensure that the IllegalArgumentException is thrown.
     */
    @Test
    public void testCheckGroupCapacities_GroupSizeZero() {
        ExerciseGroupManager manager = new ExerciseGroupManager();
        assertThrows(IllegalArgumentException.class, () -> {
            manager.checkGroupCapacities(30, 0, 3);
        });
    }

    /**
     * Tests the checkGroupCapacities method of ExerciseGroupManager for the scenario
     * where the number of available groups is zero.
     *
     * The test initializes the ExerciseGroupManager and verifies that an
     * IllegalArgumentException is thrown when the availableGroups parameter is zero,
     * since this is an invalid input as there must be at least one group available.
     *
     * This behavior is verified using assertThrows to ensure that the IllegalArgumentException is thrown.
     */
    @Test
    public void testCheckGroupCapacities_AvailableGroupsZero() {
        ExerciseGroupManager manager = new ExerciseGroupManager();
        assertThrows(IllegalArgumentException.class, () -> {
            manager.checkGroupCapacities(30, 10, 0);
        });
    }

    /**
     * Tests the checkGroupCapacities method of ExerciseGroupManager for the case where the total number of students
     * does not fit exactly into the specified number of groups each with a certain capacity, leading to an uneven distribution.
     *
     * The test initializes the ExerciseGroupManager and checks if 35 students can be distributed among 3 groups, each
     * with a capacity of 10 students. The expected result is 5, indicating that there is an overcapacity of 5 students.
     *
     * The expected output is verified using an assertion to ensure the actual result matches the expected outcome.
     */
    @Test
    public void testCheckGroupCapacities_NormalCaseUnevenDistribution() {
        ExerciseGroupManager manager = new ExerciseGroupManager();
        int result = manager.checkGroupCapacities(35, 10, 3);
        assertEquals(5, result);
    }
}