interface Payable {
    double calculatePayment();
}

abstract class Employee implements Payable {
    private String name;
    private String id;

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public String getId() { return id; }

    @Override
    public String toString() {
        return "Employee[name=" + name + ", id=" + id + "]";
    }
}

class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(String name, String id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculatePayment() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee[name=" + getName() +
               ", salary=" + monthlySalary + "]";
    }
}

class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(String name, String id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePayment() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return "HourlyEmployee[name=" + getName() +
               ", hours=" + hoursWorked +
               ", rate=" + hourlyRate + "]";
    }
}

class Invoice implements Payable {
    private String vendor;
    private double amount;

    public Invoice(String vendor, double amount) {
        this.vendor = vendor;
        this.amount = amount;
    }

    @Override
    public double calculatePayment() {
        return amount;
    }

    @Override
    public String toString() {
        return "Invoice[vendor=" + vendor + ", amount=" + amount + "]";
    }
}

class PayrollProcessor {
    private Payable[] items;
    private int count;

    public PayrollProcessor(int capacity) {
        items = new Payable[capacity];
        count = 0;
    }

    public void addPayable(Payable p) {
        if (count < items.length) {
            items[count++] = p;
        } else {
            System.out.println("Processor full, cannot add more.");
        }
    }

    public double totalPayment() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += items[i].calculatePayment();
        }
        return total;
    }

    public Payable largestPayment() {
        if (count == 0) return null;
        Payable largest = items[0];
        for (int i = 1; i < count; i++) {
            if (items[i].calculatePayment() > largest.calculatePayment()) {
                largest = items[i];
            }
        }
        return largest;
    }

    public void countTypes() {
        int employees = 0, nonEmployees = 0;
        for (int i = 0; i < count; i++) {
            if (items[i] instanceof Employee) employees++;
            else nonEmployees++;
        }
        System.out.println("Employees=" + employees + ", Non-Employees=" + nonEmployees);
    }

    public void reportAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i].toString() +
                               " -> Payment=" + items[i].calculatePayment());
        }
    }
}

public class PayrollManagementApp {
    public static void main(String[] args) {
        PayrollProcessor processor = new PayrollProcessor(10);

        processor.addPayable(new SalariedEmployee("Alice", "E01", 3000));
        processor.addPayable(new HourlyEmployee("Bob", "E02", 20, 120));
        processor.addPayable(new Invoice("StationerySupplier", 450));
        processor.addPayable(new SalariedEmployee("Carol", "E03", 4000));
        processor.addPayable(new HourlyEmployee("David", "E04", 25, 100));

        System.out.println("=== Payroll Report ===");
        processor.reportAll();

        System.out.println("\nTotal Payment = " + processor.totalPayment());
        System.out.println("Largest Payment = " + processor.largestPayment());
        System.out.println("\n=== Count by Type ===");
        processor.countTypes();
    }
}
