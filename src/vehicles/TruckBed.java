package vehicles;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Represents a truck bed.
 * The bed can be raised to a certain angle and can be loaded to a certain limit.
 * Load represented by a stack.
 */
public class TruckBed<T> {

    protected int angle;
    protected int maxAngle;
    protected boolean bedRaised;
    protected int maxLoad;
    protected Deque<T> load;


    public TruckBed(int maxLoad, int maxAngle) {
        this.angle = 0;
        this.maxAngle = maxAngle;
        this.bedRaised = false;
        this.maxLoad = maxLoad;
        this.load = new ArrayDeque<>();
    }

    /**
     * Returns the angle of the truck bed.
     * @return integer angle in degrees
     */
    public int getAngle() {
        return angle;
    }

    /**
     * Returns max load of the truck bed.
     * @return integer indicating max load
     */
    public int getMaxLoad() {
        return maxLoad;
    }

    /**
     * Returns boolean value of whether the truck bed is raised or not.
     * @return boolean bedRaised
     */
    public boolean bedIsRaised() {
        return bedRaised;
    }

    /**
     * Returns the size of the load currently loaded on the truck bed.
     * @return integer indicating load size
     */
    public int loadSize() {
        return load.size();
    }

    /**
     * Sets boolean bedRaised as either true or false depending on the angle of the truck bed.
     * An angle of 0 sets false and anything above sets true.
     */
    public void setBedRaised() {
        if (angle == 0) {
            bedRaised = false;
        }
        else {
            bedRaised = true;
        }
    }

    /**
     * Loads the truck bed with an object.
     * @param t the object
     */
    public void loadBed(T t) {
        load.push(t);
    }

    /**
     * Unloads an object from the truck bed.
     * @return object of type T.
     */
    public T unloadBed() {
        return load.pop();
    }

    /**
     * Increases the angle of the truck bed if the current speed of the vehicle is 0.
     * Calls function setAngle.
     * @param amount the increase of the angle in degrees
     * @param speed the current speed of the vehicle
     */
    public void increaseAngle(int amount, double speed) {
        if (speed == 0) {
            setAngle(amount + angle);
        }
    }

    /**
     * Decreases the angle of the truck bed. Calls function setAngle.
     * @param amount the increase of the angle in degrees
     */
    public void decreaseAngle(int amount) {
        setAngle(angle - amount);
    }

    /**
     * Sets the angle of the truck bed according to an amount.
     * Calls setBedRaised after adjustment.
     * @param amount the amount in degrees to set the angle to
     */
    private void setAngle(int amount) {
        if (amount < 0) {
            angle = 0;
        }
        else if (amount > maxAngle) {
            angle = maxAngle;
        }
        else {
            angle = amount;
        }
        setBedRaised();
    }
}


