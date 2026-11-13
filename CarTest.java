import java.awt.*;

public class CarTest {
    private static void reportResult(String testName, boolean success) {
        IO.println((success ? "SUCCESS: " : "FAILURE: ") + testName);
    }

    /** Tests whether a Saab95 with turbo enabled
     *  gains more speed than one without.
     */
    private static void testTurbo() {
        Saab95 slowSaab = new Saab95(4, 125, Color.red, "Saab95", false);
        Saab95 fastSaab = new Saab95(4, 125, Color.red, "Saab95", false);
        fastSaab.setTurboOn();
        slowSaab.setTurboOff();
        fastSaab.gas(0.5);
        slowSaab.gas(0.5);
        boolean result = slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();
        reportResult("Turbo yields more speed", result);
    }

    private static void testDirection() {
        Volvo240 testVolvo = new Volvo240(4, 100, Color.blue, "Volvo240");
        testVolvo.direction = 2;
        double firstX = testVolvo.x;
        IO.println("Position: " + testVolvo.x + " " + testVolvo.y);
        testVolvo.startEngine();
        testVolvo.move();
        IO.println("Position: " + testVolvo.x + " " + testVolvo.y);
        boolean result = firstX > testVolvo.x;
        reportResult("Volvo moved backwards", result);
    }

    private static void testSpeed() {
        Volvo240 testVolvo = new Volvo240(4, 150, Color.yellow, "Volvo240");
        IO.println("Speed before increment: " + testVolvo.getCurrentSpeed());
        double speedBefore = testVolvo.getCurrentSpeed();
        testVolvo.incrementSpeed(4);
        IO.println("Speed after increment: " + testVolvo.getCurrentSpeed());
        testVolvo.direction = 0;
        testVolvo.move();
        IO.println("Position: " + testVolvo.x + " " + testVolvo.y);
        boolean result = speedBefore < testVolvo.getCurrentSpeed();
        reportResult("Speed increased", result);
    }

    private static void testBrake() {
        Saab95 testSaab = new Saab95(2, 85, Color.pink, "Saab95", false);
        testSaab.currentSpeed = 10;
        double speedBefore = testSaab.getCurrentSpeed();
        IO.println("Speed before brake: " + testSaab.currentSpeed);
        testSaab.brake(3); // Testing invalid brake value -> turns it into 1
        IO.println("Speed after brake: " + testSaab.currentSpeed);
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