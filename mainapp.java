import java.util.*;

class Student {
    String id, name, email;
    List<Course> courses = new ArrayList<>();

    Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    void enroll(Course c) {
        courses.add(c);
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + email + " | Courses: " + courses.size();
    }
}

class Course {
    String code, title;
    int credits;

    Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return code + " - " + title + " (" + credits + " cr)";
    }
}

public class MainApp {
    static List<Student> students = new ArrayList<>();
    static List<Course> courses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Campus Course & Records Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Add Course");
            System.out.println("4. List Courses");
            System.out.println("5. Enroll Student in Course");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> addStudent();
                case 2 -> listStudents();
                case 3 -> addCourse();
                case 4 -> listCourses();
                case 5 -> enrollStudent();
                case 6 -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter ID: "); String id = sc.nextLine();
        System.out.print("Enter Name: "); String name = sc.nextLine();
        System.out.print("Enter Email: "); String email = sc.nextLine();
        students.add(new Student(id, name, email));
        System.out.println("Student added.");
    }

    static void listStudents() {
        if (students.isEmpty()) System.out.println("No students yet.");
        else students.forEach(System.out::println);
    }

    static void addCourse() {
        System.out.print("Enter Code: "); String code = sc.nextLine();
        System.out.print("Enter Title: "); String title = sc.nextLine();
        System.out.print("Enter Credits: "); int cr = sc.nextInt(); sc.nextLine();
        courses.add(new Course(code, title, cr));
        System.out.println("Course added.");
    }

    static void listCourses() {
        if (courses.isEmpty()) System.out.println("No courses yet.");
        else courses.forEach(System.out::println);
    }

    static void enrollStudent() {
        if (students.isEmpty() || courses.isEmpty()) {
            System.out.println("Add students and courses first.");
            return;
        }
        System.out.print("Enter Student ID: ");
        String sid = sc.nextLine();
        Student s = students.stream().filter(x -> x.id.equals(sid)).findFirst().orElse(null);
        if (s == null) { System.out.println("Student not found."); return; }

        System.out.print("Enter Course Code: ");
        String cc = sc.nextLine();
        Course c = courses.stream().filter(x -> x.code.equals(cc)).findFirst().orElse(null);
        if (c == null) { System.out.println("Course not found."); return; }

        s.enroll(c);
        System.out.println("Enrolled " + s.name + " in " + c.title);
    }
}
