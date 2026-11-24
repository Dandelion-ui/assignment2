import java.awt.*;

abstract class Car implements Movable {
    private int nrDoors;
    public double enginePower;
    public double currentSpeed;
    private Color color;
    private String modelName;
    public int x = 0;
    public int y = 0;
    public int direction = 0;


    public void uTurn() {
        if (this.direction == 0) { //2 = up, 3 = right, 0 = down, 1 = left
            this.direction = 2;
        } else if (this.direction == 1) {
            this.direction = 3;
        } else if (this.direction == 2) {
            this.direction = 0;
        } else if (this.direction == 3) {
            this.direction = 1;
        }
    }

    public Car setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Point getPosition() {
        Point a = new Point(this.x, this.y);
        return a;
    }

    public void turnLeft() {
        if (this.direction == 0) {
            this.direction = 3;
        } else {
            this.direction--;
        }
    }
    public void turnRight() {
        if (this.direction == 3) {
            this.direction = 0;
        } else {
            this.direction++;
            }
        }

    //public void turnRight() {
    //    this.direction = (this.direction + 1) % 4;
    //}

    public void move() {
        if (this.direction == 0) {
            this.y += this.currentSpeed;
        } else if (this.direction == 1) {
            this.x -= this.currentSpeed;
        } else if (this.direction == 2) {
            this.y -= this.currentSpeed;
        } else if (this.direction == 3) {
            this.x += this.currentSpeed;
        }

    }

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = (double) 0.0F;
        this.color = color;
        this.modelName = modelName;
    }

    public int getNrDoors() {
        return this.nrDoors;
    }

    public double getEnginePower() {
        return this.enginePower;
    }

    public double getCurrentSpeed() {
        this.currentSpeed = this.checkInterval(this.currentSpeed, this.enginePower);
        return this.currentSpeed;
    }

    public Color getColor() {
        return this.color;
    }

    public String getModelName() {
        return this.modelName;
    }

    public double speedFactor() {
        return (double) 0.0F;
    }

    public void setColor(Color clr) {
        this.color = clr;
    }

    public void startEngine() {
        this.currentSpeed = 0.1;
    }

    public void stopEngine() {
        this.currentSpeed = (double) 0.0F;
    }

    public void incrementSpeed(double amount) {
        this.currentSpeed = this.getCurrentSpeed() + this.speedFactor() * amount;
    }

    public void decrementSpeed(double amount) {
        this.currentSpeed = this.getCurrentSpeed() - this.speedFactor() * amount;
    }

    public void gas(double amount) {
        amount = this.checkInterval(amount, (double) 1.0F);
        this.incrementSpeed(amount);
    }

    public void brake(double amount) {
        amount = this.checkInterval(amount, (double) 1.0F);
        this.decrementSpeed(amount);
    }

    public double checkInterval(double amount, double limit) {
        if (amount < (double) 0.0F) {
            amount = (double) 0.0F;
        } else if (amount > limit) {
            amount = limit;
        }

        return amount;
    }
}

