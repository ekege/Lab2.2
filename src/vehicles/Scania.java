package vehicles;


import java.awt.*;

/**
 * A class representing a truck by the brand "Scania".
 * Incorporates a bed of object TruckBed through composition.
 * Bed can only be raised while standing still and vehicle can't move while bed is raised.
 */
public class Scania extends Vehicle {

    private TruckBed<?> bed;

    public Scania(){
        super(2, Color.blue, 110, "Scania");
        this.bed = new TruckBed<Object>(10, 70);
    }

    /**
     * Calls getAngle in TruckBed to get the current angle of the bed.
     * @return the angle of the bed in degrees.
     */
    public int getBedAngle() {
        return bed.getAngle();
    }

    /**
     * Calls increaseAngle in class TruckBed to raise the bed.
     * @param amount the amount to raise the bed with
     */
    public void increaseBedAngle(int amount) {
        bed.increaseAngle(amount,this.getCurrentSpeed());
    }

    /**
     * Calls increaseAngle in class TruckBed to raise the bed.
     * @param amount the amount to lower the bed with
     */
    public void decreaseBedAngle(int amount) {
        bed.decreaseAngle(amount);
    }

    /**
     * Overrides to make sure the engine can't be started if the flatbed is raised.
     * Starts engine if flatbed i lowered fully.
     */
    @Override
    public void startEngine() {
        if (!bed.bedIsRaised())
            currentSpeed = 0.1;
    }

    /**
     * Overrides to make sure the gas can't be used if the flatbed is raised.
     * Calls incrementSpeed with the amount if the flatbed is lowered fully.
     * @param amount the amount to increment.
     */
    @Override
    public void gas(double amount) {
        if (amount < 0 || amount > 1)
            throw new IllegalArgumentException("Argument must be in the range [0,1]");
        else if (!bed.bedIsRaised()) {
            incrementSpeed(amount);
        }
    }

    /**
     * Overrides abstract function.
     * @return speedFactor
     */
    @Override
    protected double speedFactor(){
        return enginePower * 0.01;
    }


}
