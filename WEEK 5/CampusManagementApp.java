abstract class Person {
    private String name; 

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return "Person[name=" + name + "]";
    }
}

class Student extends Person {
    private int[] grades;

    public Student(String name, int[] grades) {
        super(name);
        this.grades = grades;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public double averageGrade() {
        int sum = 0;
        for (int g : grades) sum += g;
        return (grades.length > 0) ? (double) sum / grades.length : 0;
    }

    @Override
    public String toString() {
        return "Student[name=" + getName() + ", avgGrade=" + averageGrade() + "]";
    }
}

class Instructor extends Person {
    private String subject;

    public Instructor(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    @Override
    public String getRole() {
        return "Instructor";
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Instructor[name=" + getName() + ", subject=" + subject + "]";
    }
}

class Administrator extends Person {
    private String department;

    public Administrator(String name, String department) {
        super(name);
        this.department = department;
    }

    @Override
    public String getRole() {
        return "Administrator";
    }

    @Override
    public String toString() {
        return "Administrator[name=" + getName() + ", dept=" + department + "]";
    }
}

class CampusRegistry {
    private Person[] people;
    private int count;

    public CampusRegistry(int capacity) {
        people = new Person[capacity];
        count = 0;
    }

    public void addPerson(Person p) {
        if (count < people.length) {
            people[count++] = p;
        } else {
            System.out.println("Registry full, cannot add " + p.getName());
        }
    }

    public Person searchByName(String name) {
        for (int i = 0; i < count; i++) {
            if (people[i].getName().equalsIgnoreCase(name)) {
                return people[i];
            }
        }
        return null;
    }

    public void countByType() {
        int students = 0, instructors = 0, admins = 0;
        for (int i = 0; i < count; i++) {
            if (people[i] instanceof Student) students++;
            else if (people[i] instanceof Instructor) instructors++;
            else if (people[i] instanceof Administrator) admins++;
        }
        System.out.println("Students=" + students +
                           ", Instructors=" + instructors +
                           ", Administrators=" + admins);
    }

    public void reportAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(people[i].toString());
            if (people[i] instanceof Instructor) {
                Instructor ins = (Instructor) people[i];
                System.out.println("   Teaches: " + ins.getSubject());
            }
        }
    }
}

public class CampusManagementApp {
    public static void main(String[] args) {
        CampusRegistry registry = new CampusRegistry(10);

        registry.addPerson(new Student("Alice", new int[]{85, 90, 78}));
        registry.addPerson(new Instructor("Bob", "Physics"));
        registry.addPerson(new Administrator("Carol", "Admissions"));
        registry.addPerson(new Student("David", new int[]{70, 88, 92}));
        registry.addPerson(new Instructor("Eve", "Mathematics"));

        System.out.println("=== Campus Report ===");
        registry.reportAll();

        System.out.println("\n=== Search Result ===");
        Person found = registry.searchByName("Alice");
        System.out.println(found != null ? found : "Not found");

        System.out.println("\n=== Count by Type ===");
        registry.countByType();
    }
}
