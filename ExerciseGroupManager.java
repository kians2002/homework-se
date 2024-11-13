
public class ExerciseGroupManager {
    /**
     * This method is used to regularly check whether the maximum capacity of students for the available groups has been exceeded.
     *
     * @param totalStudents The total number of students to assign.
     * @param groupSize The maximum number of students in each group.
     * @param availableGroups The total number of groups available for assignment.
     * @return The number of students that must be assigned with the current number of registered students and available groups. Returns 0 in case totalStudents <= 0.
     * @throws IllegalArgumentException if group size or number of groups is zero or negative.
     */
    public int checkGroupCapacities(int totalStudents, int groupSize, int availableGroups) {
        if (groupSize <= 0 || availableGroups <= 0) {
            throw new IllegalArgumentException("Group size and number of groups must be greater than zero.");
        }
        if (totalStudents <= 0) {
            return 0;
        }

        int totalCapacity = groupSize * availableGroups;
        if (totalStudents > totalCapacity) {
            return totalStudents - totalCapacity;
        } else {
            return 0;
        }


    }
}