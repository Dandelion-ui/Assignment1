import java.awt.*;

abstract class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName;
    public double x = 0;
    public double y = 0;
    public int direction = 0;

    @Override
    public void turnLeft() {
        if (direction == 0) {
            direction = 3;
        }else{
            direction = direction - 1;
        }
    }

    @Override
    public void turnRight() {
        direction = (direction + 1) % 4;
    }

    @Override
    public void move() {
        if (direction == 0){ // Up
            y += currentSpeed;
        } else if (direction == 1) { // Right
            x += currentSpeed;
        } else if (direction == 2) { // Down
            x -= currentSpeed;
        } else if (direction == 3) { // Left
            x -= currentSpeed;
        }
    }

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        this.modelName = modelName;
    }

    public int getNrDoors() {return nrDoors;}

    public double getEnginePower() {return enginePower;}

    public double getCurrentSpeed() {
        currentSpeed = checkInterval(currentSpeed, enginePower);
        return currentSpeed;
    }

    public Color getColor() {return color;}

    public String getModelName() {return modelName;}

    public double speedFactor() {return 0;}

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    public void gas(double amount) {
        amount = checkInterval(amount, 1);
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        amount = checkInterval(amount, 1);
        decrementSpeed(amount);
    }

    public double checkInterval(double amount, double limit) {
        if (amount < 0) {
            amount = 0;
        } else if (amount > limit) {
            amount = limit;
        }
        return amount;
    }
}


class Saab95 extends Car {
    private boolean turboOn;

    public Saab95(int nrDoors, double enginePower, Color color, String modelName, boolean turboOn) {
        super(nrDoors, enginePower, color, modelName);
        this.turboOn = turboOn;
    }

    @Override public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
    public boolean isTurboOn() {
        return turboOn;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

}
class Volvo240 extends Car {
    private final static double trimFactor = 1.25;

    public Volvo240(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    @Override
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
 class Main {
    public static void main(String[] args) {
        // Test your cars here
    }
}


