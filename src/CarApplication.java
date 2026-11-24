import java.awt.*;

void main() {
    // Instance of this class
    CarController cc = new CarController();


    // TODO uncomment, and adapt if necessary
    cc.cars.add(new Volvo240(4, (double)150.0F, Color.yellow, "Volvo240").setPosition(300, 100));
    cc.cars.add(new Saab95(4, 150, Color.blue, "Saab95", false).setPosition(500, 0));


    // Start a new view and send a reference to the controller
    cc.frame = new CarView("CarSim 1.0", cc);

    cc.startTimer();
}