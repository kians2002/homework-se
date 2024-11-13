import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager<Student> studentManager = new EntityManager<>();
        EntityManager<Lecturer> lecturerManager = new EntityManager<>();
        EntityManager<Course> courseManager = new EntityManager<>();

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Kian");
        student1.setLastname("Shahroudi");

        Lecturer lecturer1 = new Lecturer();
        lecturer1.setId(1);
        lecturer1.setName("Alex");
        lecturer1.setLastname("Korn");

        Course course1 = new Course();
        course1.setId(1);
        course1.setName("Softwaretechnik");

        studentManager.addEntity(student1);
        lecturerManager.addEntity(lecturer1);
        courseManager.addEntity(course1);

        // Example of filtering students by name
        List<Student> filteredStudents = studentManager.filterEntities(s -> s.getName().equals("Kian"));
        for (Student student : filteredStudents) {
            System.out.println("Filtered Student: " + student.getName() + " " + student.getLastname());
        }

        // Example of filtering lecturers by last name
        List<Lecturer> filteredLecturers = lecturerManager.filterEntities(l -> l.getLastname().equals("Korn"));
        for (Lecturer lecturer : filteredLecturers) {
            System.out.println("Filtered Lecturer: " + lecturer.getName() + " " + lecturer.getLastname());
        }

        // Example of filtering courses by name
        List<Course> filteredCourses = courseManager.filterEntities(c -> c.getName().equals("Softwaretechnik"));
        for (Course course : filteredCourses) {
            System.out.println("Filtered Course: " + course.getName());
        }
    }
}
