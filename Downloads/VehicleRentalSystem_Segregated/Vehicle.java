import java.util.Random;

public abstract class Vehicle implements Rentable {
    protected String brand;
    protected String model;
    protected double baseRate;
    protected String vehicleNumber;

    public Vehicle(String brand, String model, double baseRate) {
        this.brand = brand;
        this.model = model;
        this.baseRate = baseRate;
        this.vehicleNumber = generateVehicleNumber();
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getBaseRate() { return baseRate; }
    public String getVehicleNumber() { return vehicleNumber; }

    private String generateVehicleNumber() {
        Random rand = new Random();
        return "UP" + (10 + rand.nextInt(90)) + 
               (char)(rand.nextInt(26) + 'A') + 
               (char)(rand.nextInt(26) + 'A') + 
               (1000 + rand.nextInt(9000));
    }

    public abstract String getType();
}
