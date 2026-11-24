import java.awt.Color;

class Volvo240 extends Car {
    private static final double trimFactor = (double)1.25F;

    public Volvo240(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    public double speedFactor() {
        return this.enginePower * 0.01 * (double)1.25F;
    }
}
