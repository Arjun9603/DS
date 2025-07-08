import java.util.*;

public class VehicleRentalSystem {
    static List<Vehicle> inventory = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        seedVehicles();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter license number: ");
        String license = sc.nextLine();

        Customer customer = new Customer(name, license);

        while (true) {
            System.out.println("\n===== VEHICLE RENTAL MENU =====");
            System.out.println("1. View Available Vehicles");
            System.out.println("2. Rent a Vehicle");
            System.out.println("3. View Rental History");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> displayInventory();
                case 2 -> rentVehicle(customer);
                case 3 -> customer.viewHistory();
                case 4 -> {
                    System.out.println("Thank you for using Vehicle Rental System!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void seedVehicles() {
        inventory.add(new Bike("Yamaha", "FZ", 300));
        inventory.add(new Bike("Honda", "Shine", 250));
        inventory.add(new Car("Hyundai", "i20", 1200));
        inventory.add(new Car("Toyota", "Innova", 1800));
        inventory.add(new Truck("Tata", "407", 2000));
        inventory.add(new Truck("Eicher", "Pro", 2300));
    }

    static void displayInventory() {
        System.out.println("\n🛞 Available Vehicles:");
        int index = 1;
        for (Vehicle v : inventory) {
            System.out.println(index++ + ". " + v.getType() + " - " + v.getBrand() + " " + v.getModel() + " (₹" + v.getBaseRate() + "/day)");
        }
    }

    static void rentVehicle(Customer customer) {
        displayInventory();
        System.out.print("Select vehicle number to rent: ");
        int vehicleIndex = sc.nextInt();
        sc.nextLine();

        if (vehicleIndex < 1 || vehicleIndex > inventory.size()) {
            System.out.println("Invalid vehicle selection.");
            return;
        }

        Vehicle selected = inventory.get(vehicleIndex - 1);
        System.out.print("Enter number of days to rent: ");
        int days = sc.nextInt();
        sc.nextLine();

        customer.rentVehicle(selected, days);
    }
}
