public class Car extends Vehicle {
    public Car(String brand, String model, double baseRate) {
        super(brand, model, baseRate);
    }

    public double calculateRent(int days) {
        double surcharge = 200;
        return (baseRate * days) + surcharge;
    }

    public String getType() { return "Car"; }
}
