package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Course java = new Course("Java");
        Course javaCore = new Course("JavaCore");
        Course theory = new Course("Theory");
        Course sql = new Course("SQL");
        Course practice = new Course("Practice");

        students.add(new Student("Вася", Arrays.asList(java, javaCore,theory,practice)));
        students.add(new Student("Боря", Arrays.asList(java, javaCore, sql,theory,practice)));
        students.add(new Student("Сережа", Arrays.asList(java, theory,practice)));
        students.add(new Student("Максим", Arrays.asList(java,theory,practice)));
        students.add(new Student("Олег", Arrays.asList(sql)));

        System.out.println("Список уникальных курсов :");
        uniqueCourses(students).forEach(s -> System.out.println(s.getCourseName()));
        System.out.println();
        System.out.println("Самые любознательные :");
        mostCurious(students).forEach(s -> System.out.println(s.getName() + ". Кол-во курсов " + s.getAllCourses().size()));
        System.out.println();
        System.out.printf("Курс %s проходили: \n", sql.getCourseName());
        courseContained(students, sql).forEach(s -> System.out.println(s.getName()));
    }

    public static List<Course> uniqueCourses(List<Student> students)  {
        List<Course> uCourse = students.stream()
                .flatMap(student -> student.getAllCourses().stream())
                .distinct()
                .collect(Collectors.toList());
        return uCourse;
    }

    public static List<Student> mostCurious(List<Student> students)  {
        List<Student> stList = students.stream()
                .sorted((o1, o2) -> o2.getAllCourses().size() - o1.getAllCourses().size())
                .limit(3)
                .collect(Collectors.toList());
        return stList;
    }

    public static List<Student> courseContained(List<Student> students, Course course)  {
        List<Student> stList = students.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
        return stList;
    }
}
