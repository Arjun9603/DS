public class Truck extends Vehicle {
    public Truck(String brand, String model, double baseRate) {
        super(brand, model, baseRate);
    }

    public double calculateRent(int days) {
        double discount = 100;
        return (baseRate * days) - discount;
    }

    public String getType() { return "Truck"; }
}
