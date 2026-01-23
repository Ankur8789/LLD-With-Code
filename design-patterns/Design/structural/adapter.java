// AdapterPatternWeightMachine.java
// Single-file Java example of Adapter Pattern using Weight Machine analogy

// Target interface (what client expects)
interface WeightMachine {
    // returns weight in KG
    double getWeightInKg();
}

// Adaptee (existing / incompatible class)
class WeightMachineInPounds {

    public double getWeightInPounds() {
        return 150.0; // weight in pounds
    }
}

// Adapter
class WeightMachineAdapter implements WeightMachine {

    private WeightMachineInPounds weightMachineInPounds;

    public WeightMachineAdapter(WeightMachineInPounds weightMachineInPounds) {
        this.weightMachineInPounds = weightMachineInPounds;
    }

    @Override
    public double getWeightInKg() {
        double pounds = weightMachineInPounds.getWeightInPounds();
        return pounds * 0.453592; // convert pounds to kg
    }
}

// Client
public class AdapterPatternWeightMachine {
    public static void main(String[] args) {

        // Existing machine gives weight in pounds
        WeightMachineInPounds legacyMachine = new WeightMachineInPounds();

        // Adapter converts it to what client expects (KG)
        WeightMachine weightMachine = new WeightMachineAdapter(legacyMachine);

        System.out.println("Weight in KG: " + weightMachine.getWeightInKg());
    }
}
