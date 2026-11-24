import java.awt.Color;

public class CarTest {
    public CarTest() {
    }

    private static void reportResult(String testName, boolean success) {
        IO.println((success ? "SUCCESS: " : "FAILURE: ") + testName);
    }

    private static void testTurbo() {
        Saab95 slowSaab = new Saab95(4, (double)125.0F, Color.red, "Saab95", false);
        Saab95 fastSaab = new Saab95(4, (double)125.0F, Color.red, "Saab95", false);
        fastSaab.setTurboOn();
        slowSaab.setTurboOff();
        fastSaab.gas((double)0.5F);
        slowSaab.gas((double)0.5F);
        boolean result = slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();
        reportResult("Turbo yields more speed", result);
    }

    private static void testDirection() {
        Volvo240 testVolvo = new Volvo240(4, (double)100.0F, Color.blue, "Volvo240");
        testVolvo.direction = 2;
        double firstX = testVolvo.x;
        double var10000 = testVolvo.x;
        IO.println("Position: " + var10000 + " " + testVolvo.y);
        testVolvo.startEngine();
        testVolvo.move();
        var10000 = testVolvo.x;
        IO.println("Position: " + var10000 + " " + testVolvo.y);
        boolean result = firstX > testVolvo.x;
        reportResult("Volvo moved backwards", result);
    }

    private static void testSpeed() {
        Volvo240 testVolvo = new Volvo240(4, (double)150.0F, Color.yellow, "Volvo240");
        double var10000 = testVolvo.getCurrentSpeed();
        IO.println("Speed before increment: " + var10000);
        double speedBefore = testVolvo.getCurrentSpeed();
        testVolvo.incrementSpeed((double)4.0F);
        var10000 = testVolvo.getCurrentSpeed();
        IO.println("Speed after increment: " + var10000);
        testVolvo.direction = 0;
        testVolvo.move();
        var10000 = testVolvo.x;
        IO.println("Position: " + var10000 + " " + testVolvo.y);
        boolean result = speedBefore < testVolvo.getCurrentSpeed();
        reportResult("Speed increased", result);
    }

    private static void testBrake() {
        Saab95 testSaab = new Saab95(2, (double)85.0F, Color.pink, "Saab95", false);
        testSaab.currentSpeed = (double)10.0F;
        double speedBefore = testSaab.getCurrentSpeed();
        double var10000 = testSaab.currentSpeed;
        IO.println("Speed before brake: " + var10000);
        testSaab.brake((double)3.0F);
        var10000 = testSaab.currentSpeed;
        IO.println("Speed after brake: " + var10000);
        boolean result = speedBefore > testSaab.getCurrentSpeed();
        reportResult("Invalid value turned into 1 and brake decreases speed", result);
    }

    static void main() {
        testTurbo();
        testDirection();
        testSpeed();
        testBrake();
    }
}
