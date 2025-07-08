import java.util.*;

public class Customer {
    private String name;
    private String licenseNumber;
    private List<String> history;

    public Customer(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.history = new ArrayList<>();
    }

    public String getName() { return name; }

    public void rentVehicle(Vehicle vehicle, int days) {
        String bookingId = UUID.randomUUID().toString().substring(0, 8);
        double cost = vehicle.calculateRent(days);
        String transaction = "Booking ID: " + bookingId +
                "\nVehicle: " + vehicle.getType() + " - " + vehicle.getBrand() + " " + vehicle.getModel() +
                "\nVehicle Number: " + vehicle.getVehicleNumber() +
                "\nDuration: " + days + " days" +
                "\nTotal Rent: ₹" + cost + "\n";

        history.add(transaction);
        System.out.println("\n✅ Booking Successful!\n" + transaction);
    }

    public void viewHistory() {
        if (history.isEmpty()) {
            System.out.println("\nNo rental history available.");
        } else {
            System.out.println("\n📜 Rental History for " + name + ":");
            for (String record : history) {
                System.out.println(record);
            }
        }
    }
}
