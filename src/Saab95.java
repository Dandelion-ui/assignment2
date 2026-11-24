import java.awt.Color;

class Saab95 extends Car {
    private boolean turboOn;

    public Saab95(int nrDoors, double enginePower, Color color, String modelName, boolean turboOn) {
        super(nrDoors, enginePower, color, modelName);
        this.turboOn = turboOn;
    }

    public double speedFactor() {
        double turbo = (double)1.0F;
        if (this.turboOn) {
            turbo = 1.3;
        }

        return this.enginePower * 0.01 * turbo;
    }

    public boolean isTurboOn() {
        return this.turboOn;
    }

    public void setTurboOn() {
        this.turboOn = true;
    }

    public void setTurboOff() {
        this.turboOn = false;
    }
}
