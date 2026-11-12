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
        testVolvo.turnRight();
        IO.println("Position: " + testVolvo.x + " " + testVolvo.y);
        testVolvo.startEngine();
        testVolvo.move();
        IO.println("Position: " + testVolvo.x + " " + testVolvo.y);
    }

    private static void testSpeed() {
        Volvo240 testVolvo = new Volvo240(4, 150, Color.yellow, "Volvo240");
        IO.println(testVolvo.getCurrentSpeed());
        testVolvo.incrementSpeed(4);
        IO.println(testVolvo.getCurrentSpeed());
        testVolvo.direction = 0;
        testVolvo.move();
        IO.println("Position: " + testVolvo.x + " " + testVolvo.y);
    }

    private static void testBrake() {
        Saab95 testSaab = new Saab95(2, 85, Color.pink, "Saab95", false);
        testSaab.currentSpeed = 10;
        IO.println(testSaab.currentSpeed);
        testSaab.brake(3);
        IO.println(testSaab.currentSpeed);

    }

    static void main() {
        testTurbo();
        testDirection();
        testSpeed();
        testBrake();

    }
}