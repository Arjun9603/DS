public class Bike extends Vehicle {
    public Bike(String brand, String model, double baseRate) {
        super(brand, model, baseRate);
    }

    public double calculateRent(int days) {
        return baseRate * days;
    }

    public String getType() { return "Bike"; }
}
